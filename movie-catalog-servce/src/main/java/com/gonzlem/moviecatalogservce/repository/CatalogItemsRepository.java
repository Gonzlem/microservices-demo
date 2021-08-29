package com.gonzlem.moviecatalogservce.repository;

import com.gonzlem.moviecatalogservce.models.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemsRepository extends JpaRepository<CatalogItem, Integer> {
}
