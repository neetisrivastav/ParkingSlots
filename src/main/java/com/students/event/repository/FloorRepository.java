package com.students.event.repository;

import com.students.event.buildingModel.Floor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "floor", path = "floors")
public interface FloorRepository extends PagingAndSortingRepository<Floor, Long> {


}
