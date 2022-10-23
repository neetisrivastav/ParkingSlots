package com.students.event.repository;

import com.students.event.buildingModel.Floor;
import com.students.event.studentModel.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(collectionResourceRel = "floor", path = "floors")
public interface FloorRepository extends PagingAndSortingRepository<Floor, Long> {


}
