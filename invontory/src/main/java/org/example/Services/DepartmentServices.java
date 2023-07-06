package org.example.Services;

import org.example.Dto.Request.DepartmentRequestDto;
import org.example.Dto.Response.StatusDto;
import org.example.dao.DepartmentsDao;
import org.example.model.Departments;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class DepartmentServices {

    @EJB
    private DepartmentsDao departmentsDao;

    public StatusDto create_department(DepartmentRequestDto departmentRequestDto){
        Departments departments = new Departments();
        departments.setName(departmentRequestDto.getName());
        departments.setCreateOn(new Date());
        departments.setStatus(departmentRequestDto.getStatus());
        this.departmentsDao.create(departments);
        return new StatusDto(true, "success");
    }

}
