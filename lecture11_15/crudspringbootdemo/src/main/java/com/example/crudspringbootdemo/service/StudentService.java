package com.example.crudspringbootdemo.service;

import com.example.crudspringbootdemo.dto.CreateStudentRequestDTO;
import com.example.crudspringbootdemo.dto.CreateStudentResponseDTO;
import com.example.crudspringbootdemo.dto.UpdateStudentRequestDTO;
import com.example.crudspringbootdemo.dto.UpdateStudentResponseDTO;
import com.example.crudspringbootdemo.entity.Student;
import com.example.crudspringbootdemo.exception.DuplicateResourceException;
import com.example.crudspringbootdemo.exception.ResourceNotFoundException;
import com.example.crudspringbootdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReqDto) {
        Student student=mapToEntity(studentReqDto);

        if(emailExists(student)){
            throw new DuplicateResourceException("Email already exists: "+student.getEmail());
        }
       
        Student studentResp=studentRepository.save(student);
        return mapToDto(studentResp);
    }

    
    public CreateStudentResponseDTO getStudent(Long id) {
        Student student=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found with id: "+id));
        return mapToDto(student);
       
    }

    public List<CreateStudentResponseDTO> getAllStudent() {
        List<Student> studentList=studentRepository.findByDeletedIsFalse();
        return studentList.stream()
        .map(this::mapToDto)
        .toList();
    }

    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO studentReq) {
        Student existingStudent=studentRepository
        .findByIdAndDeletedIsFalse(id)
        .orElseThrow(()->new ResourceNotFoundException("Student not found with id: "+id));
       
        Student studentToSave=existingStudent;

        studentToSave.setName(studentReq.getName());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        
        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(java.time.LocalDateTime.now());


        Student savedStudent=studentRepository.save(studentToSave);
        return mapToUpdateDto(savedStudent);


    }

   
    public void deleteStudent(Long id) {
        Student isStudent=studentRepository
        .findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Student not found with id: "+id));
        studentRepository.delete(isStudent);
       
    }

    public void deleteStudentSoftly(Long id) {
        Student isStudent=studentRepository
        .findByIdAndDeletedIsFalse(id)
        .orElseThrow(()->new ResourceNotFoundException("Student not found with id: "+id));
      
        
        isStudent.setDeleted(true);
        studentRepository.save(isStudent);
        
    }

     private Student mapToEntity(CreateStudentRequestDTO studentReqDto) {
       Student student=new Student();
       student.setName(studentReqDto.getName());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail());
        student.setRollNo(studentReqDto.getRollNo());
        student.setSubject(studentReqDto.getSubject());
        student.setCreatedAt(java.time.LocalDateTime.now());
        student.setUpdatedAt(java.time.LocalDateTime.now());
        student.setDeleted(false);
        return student;

    }

    private CreateStudentResponseDTO mapToDto(Student studentResp) {
        CreateStudentResponseDTO studentResponseDto=new CreateStudentResponseDTO();
        studentResponseDto.setId(studentResp.getId());
        studentResponseDto.setName(studentResp.getName());
        studentResponseDto.setAge(studentResp.getAge());
        studentResponseDto.setEmail(studentResp.getEmail());
        studentResponseDto.setRollNo(studentResp.getRollNo());
        studentResponseDto.setSubject(studentResp.getSubject());
        studentResponseDto.setMessage("Student created successfully");
        studentResponseDto.setCreatedAt(studentResp.getCreatedAt());
        studentResponseDto.setUpdatedAt(studentResp.getUpdatedAt());
        return studentResponseDto;
    }

     private UpdateStudentResponseDTO mapToUpdateDto(Student savedStudent) {
        UpdateStudentResponseDTO updateStudentResponseDTO=new UpdateStudentResponseDTO();
        updateStudentResponseDTO.setId(savedStudent.getId());
        updateStudentResponseDTO.setName(savedStudent.getName());
        updateStudentResponseDTO.setAge(savedStudent.getAge());
        updateStudentResponseDTO.setEmail(savedStudent.getEmail());
        updateStudentResponseDTO.setRollNo(savedStudent.getRollNo());
        updateStudentResponseDTO.setSubject(savedStudent.getSubject());
        updateStudentResponseDTO.setMessage("Student updated successfully");
       
        updateStudentResponseDTO.setUpdatedAt(savedStudent.getUpdatedAt());
        return updateStudentResponseDTO;
    }

    private boolean emailExists(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
        
    }
}
