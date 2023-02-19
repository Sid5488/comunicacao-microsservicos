package br.com.productapi.modules.category.repositories;

import br.com.productapi.modules.category.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {}
