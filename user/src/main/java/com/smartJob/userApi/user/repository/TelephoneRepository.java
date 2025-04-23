package com.smartJob.userApi.user.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;

import com.smartJob.userApi.user.entity.SjTelephone;

public interface TelephoneRepository  extends JpaRepository<SjTelephone, Long>  {

}
