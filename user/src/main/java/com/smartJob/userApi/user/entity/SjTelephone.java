package com.smartJob.userApi.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sj_telephones")
@Data
public class SjTelephone {
	@Id
	@GeneratedValue
	private Long id;
	private String number;
	private String citycode;
	private String contrycode;
}
