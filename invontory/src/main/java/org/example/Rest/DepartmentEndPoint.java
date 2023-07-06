package org.example.Rest;

import io.swagger.annotations.Api;
import org.example.Dto.Request.DepartmentRequestDto;
import org.example.Dto.Response.StatusDto;
import org.example.Services.DepartmentServices;
import org.example.dao.DepartmentsDao;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("/department")
@Api(value = "department")
public class DepartmentEndPoint {
    @EJB
    private DepartmentServices departmentServices;
    @EJB
    private DepartmentsDao departmentsDao;


    @POST
    @Path("/createDepartment")
    public StatusDto create(DepartmentRequestDto departmentRequestDto){
        return departmentServices.create_department(departmentRequestDto);
    }
}
