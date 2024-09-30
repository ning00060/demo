package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	// 	@OneToOne(fetch = FetchType.LAZY)
	// OneToOne- User, Address 엔티티 간의 1 : 1 관계를 매핑합니다.
	// FetchType.LAZY : 지연 로딩 전략을 사용합니다( getAddress() )
//	@OneToOne(fetch = FetchType.LAZY)
	
	// @JoinColumn : 외래키 (fk)를 설정하는 어노테이션 이다.
	// address_id 라는 이름 외래 키 컬럼이 User 테이블에 추가 됩니다. 
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> order;
}
