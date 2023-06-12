package cs544;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookDao extends JpaRepository<Book, Long>{

	

}