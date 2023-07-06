package org.act.com.rest;

import io.swagger.annotations.Api;
import org.act.com.dao.EmployeeDao;
import org.act.com.dto.Request.DateDto;
import org.act.com.dto.Request.EmployeeRequestDto;
import org.act.com.dto.Response.EmployeeResponseDto;
import org.act.com.dto.Response.ResponseListOutEmployeeDto;
import org.act.com.dto.Response.StatusDto;
import org.act.com.service.EmployeeService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.Date;
import java.util.List;

@Stateless
@Path("/employee")

@Api(value = "employee")
public class EmployeeEndpoint {
    @EJB
    private EmployeeService employeeService;
    @EJB
    private EmployeeDao employeeDao;
    @POST
    @Path("/createEmployee")

    public StatusDto create (EmployeeRequestDto employeeRequestDto){

        return employeeService.create(employeeRequestDto);


    }
    @POST
    @Path("/updateEmployee")

    public StatusDto update (EmployeeRequestDto employeeRequestDto){

        return employeeService.update(employeeRequestDto);


    }
    @POST
    @Path("/deleteEmployee")
    public StatusDto delete (EmployeeRequestDto employeeRequestDto){

        return employeeService.delete(employeeRequestDto);

    }
    @GET
    @Path("/findById")
        public EmployeeResponseDto findById(@QueryParam("id") int  id){
        return employeeService.findById(id);   }

    @GET
    @Path("/listAllEmployee")
        public ResponseListOutEmployeeDto listAllEmployee( @QueryParam("start")Integer start,@QueryParam("end") Integer end){
        return employeeService.listAllEmployee(start,end);
    }
    @GET
    @Path("/listByEmployeeName")
    public List<EmployeeResponseDto> listByEmployeeName(@QueryParam("employeeName") String name){
        return employeeService.listByEmployeeName(name);
    }


    @GET
    @Path("/listByEmployeeDate")
    public List<EmployeeResponseDto> listByEmployeeDate(DateDto dateDto){
        return employeeService.listByEmployeeDate(dateDto);
    }
}

