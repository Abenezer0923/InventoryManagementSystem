package org.act.com.rest;
import org.act.com.dao.DepartmentsDao;
import org.act.com.dto.Request.DepartmentRequestDto;
import org.act.com.dto.Response.DepartmentResponseDto;
import org.act.com.dto.Response.ResponseListOutDto;
import org.act.com.dto.Response.StatusDto;
import org.act.com.service.DepartmentService;
import io.swagger.annotations.Api;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.List;
@Stateless
@Path("/department")
@Api(value = "department")
public class DepartmentEndpoint {
    @EJB
    private DepartmentService departmentService;
    @EJB
    private DepartmentsDao departmentDao;

    @POST
    @Path("/createDepartment")

    public StatusDto create(DepartmentRequestDto departmentRequestDto){
        return departmentService.create(departmentRequestDto);
    }

    @PUT
    @Path("/updateDepartment")
    public StatusDto update (DepartmentRequestDto departmentRequestDto){
        return departmentService.update(departmentRequestDto);
    }
    @POST
    @Path("/deleteDepartment")

    public StatusDto delete (DepartmentRequestDto departmentRequestDto){

        return departmentService.delete(departmentRequestDto);

    }
    @GET
    @Path("/findById")
    public DepartmentResponseDto findById(@QueryParam("id") int  id){
        return departmentService.findById(id);   }

    @GET
    @Path("/listAllDepartment")
    public ResponseListOutDto listAllDepartment(@QueryParam("start") Integer start,@QueryParam("maximum") Integer maximum){
        return departmentService.listAllDepartment(start,maximum);
    }

    @GET
    @Path("/listByNameDepartment")
    public List<DepartmentResponseDto> listByNameDepartment(@QueryParam("departmentName") String name){
        return departmentService.listByNameDepartment(name);

    }
}



