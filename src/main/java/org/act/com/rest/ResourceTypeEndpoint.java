package org.act.com.rest;

import io.swagger.annotations.Api;
import org.act.com.dao.ResourceTypeDao;
import org.act.com.dto.Request.ResourceTypeRequestDto;
import org.act.com.dto.Response.ResourceResponseDto;
import org.act.com.dto.Response.ResourceTypeResponseDto;
import org.act.com.dto.Response.StatusDto;
import org.act.com.service.ResourceTypeService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.List;

@Stateless
@Path("/resourceType")
@Api(value = "resourceType")
public class ResourceTypeEndpoint {
    @EJB
    private ResourceTypeService resourceTypeService;
    @EJB
    private ResourceTypeDao resourceTypeDao;
    @POST
    @Path("/createresourceType")

    public StatusDto create (ResourceTypeRequestDto resourceTypeRequestDto){

        return resourceTypeService.create(resourceTypeRequestDto);


    }
    @POST
    @Path("/updateResourceType")

    public StatusDto update (ResourceTypeRequestDto resourceTypeRequestDto){

        return resourceTypeService.update(resourceTypeRequestDto);


    }

    @POST
    @Path("/deleteResourceType")

    public StatusDto delete (ResourceTypeRequestDto resourceTypeRequestDto){

        return resourceTypeService.delete(resourceTypeRequestDto);


    }
    @GET
    @Path("/findById")
    public ResourceTypeResponseDto findById(@QueryParam("id") int  id){
        return resourceTypeService.findById(id);   }

    @GET
    @Path("/listAllResourceType")

    public List<ResourceTypeResponseDto> listAllResourceType(){
        return resourceTypeService.listAllResourceType();
    }
    @GET
    @Path("/listByResourceTypeName")
    public List<ResourceTypeResponseDto> listByResourceTypeName(@QueryParam("resourceTypeName") String name){
        return resourceTypeService.listByResourceTypeName(name);

    }
}

