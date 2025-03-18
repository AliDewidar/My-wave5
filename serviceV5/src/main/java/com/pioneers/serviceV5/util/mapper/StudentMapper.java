package com.pioneers.serviceV5.util.mapper;

import com.pioneers.serviceV5.model.dto.AddressDto;
import com.pioneers.serviceV5.model.dto.StudentDto;
import com.pioneers.serviceV5.model.entity.Address;
import com.pioneers.serviceV5.model.entity.Student;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Optional;

import static com.pioneers.serviceV5.util.utils.NamingUtils.*;

@UtilityClass
public class StudentMapper {

    public StudentDto toStudentDto(@NonNull Student student) {

        StudentDto.StudentDtoBuilder studentDtoBuilder = StudentDto.builder()
                .firstName(extractFirstName(student.getFullName()))
                .secondName(extractSecondName(student.getFullName()))
                .age(student.getAge())
                .email(student.getEmail())
                .gender(student.getGender());

             Optional.ofNullable(student.getAddress())
                     .ifPresent(address -> {
                        AddressDto mappedAddressDto = AddressMapper.toAddressDto(address);
                        studentDtoBuilder.address(mappedAddressDto);
                     });
             return studentDtoBuilder.build();
    }

    public Student toStudent(@NonNull StudentDto studentDto) {

        Student.StudentBuilder studentBuilder = Student.builder()
//                .id(Utils.createRandomId()) // i set the id automatically in Student class (entity)
                .fullName(buildFullName(studentDto.getFirstName(), studentDto.getSecondName()))
                .age(studentDto.getAge())
                .email(studentDto.getEmail())
                .gender(studentDto.getGender());

        Optional.ofNullable(studentDto.getAddress())
                .ifPresent(addressDto -> {
                    Address mappedAddress = AddressMapper.toAddress(addressDto);
                    studentBuilder.address(mappedAddress);
                });
        return studentBuilder.build();
    }

    public Student updateStudent(@NonNull StudentDto newStudentDto, @NonNull Student foundStudent) {

        Student.StudentBuilder studentBuilder = Student.builder()
                .id(foundStudent.getId())
                .fullName(buildFullName(newStudentDto.getFirstName(), newStudentDto.getSecondName()))
                .age(newStudentDto.getAge())
                .email(newStudentDto.getEmail())
                .gender(newStudentDto.getGender());

        Optional.ofNullable(newStudentDto.getAddress())
                .ifPresent(addressDto -> {
                    Address mappedAddress = AddressMapper.toAddress(addressDto);
                    studentBuilder.address(mappedAddress);
                });
        return studentBuilder.build();
    }
}
