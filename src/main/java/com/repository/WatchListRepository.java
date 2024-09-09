package com.repository;
import com.modal.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchListRepository extends JpaRepository<Watchlist,Long>  {

    Watchlist findByUserId(Long userId);

}
