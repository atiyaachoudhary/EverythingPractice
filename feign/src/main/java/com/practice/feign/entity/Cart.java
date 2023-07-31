package com.practice.feign.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "cart", schema = "practice_data")
public class Cart implements Serializable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String productId;
    private String cartId;
    private String cartName;
    private String quantity;

    @Transient
    private List<Product> products = new ArrayList<>();

}