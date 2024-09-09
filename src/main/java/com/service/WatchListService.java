package com.service;

import com.modal.Coin;
import com.modal.Watchlist;
import com.modal.User;

public interface WatchListService {
    Watchlist findUserWatchlist (Long userId) throws Exception;
    Watchlist createWatchlist (User user);

    Watchlist findById(Long id) throws Exception;
    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
}
