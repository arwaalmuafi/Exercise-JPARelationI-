package com.example.schoolmanagementsoftware.Service;

import com.example.schoolmanagementsoftware.ApiResponse.ApiException;
import com.example.schoolmanagementsoftware.DTO.AddressDTO;
import com.example.schoolmanagementsoftware.Model.Address;
import com.example.schoolmanagementsoftware.Model.Teacher;
import com.example.schoolmanagementsoftware.Repository.AddressRepository;
import com.example.schoolmanagementsoftware.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getALLAddress(){
        return addressRepository.findAll();
    }


    public void addAddress(AddressDTO addressDTO){

        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new ApiException(" not found ");
        }
        Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){

        Address oldAddress=addressRepository.findAddressById(addressDTO.getTeacher_id());
        if(oldAddress==null){
            throw new ApiException("not found");
        }
        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(oldAddress);
    }


    public void deleteAddress(Integer id){
        Address address=addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("not found");
        }

        addressRepository.delete(address);
    }
}
