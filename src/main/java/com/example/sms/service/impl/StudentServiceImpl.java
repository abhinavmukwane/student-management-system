package com.example.sms.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.repository.StudentRepository;
import com.example.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	@Override
	public List<Student> getAllStudents(){
		
		return studentRepository.findAll();
	}
	
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	
	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();	
	}
	
	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}


	@Override
	public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	 
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.studentRepository.findAll(pageable);
	}
}
