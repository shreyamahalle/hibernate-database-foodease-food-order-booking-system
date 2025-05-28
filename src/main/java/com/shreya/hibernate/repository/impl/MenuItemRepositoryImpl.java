package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.MenuItem;
import com.shreya.hibernate.repository.MenuItemRepository;

import java.util.List;

public class MenuItemRepositoryImpl implements MenuItemRepository {
    @Override
    public boolean addMenuItem(MenuItem menuItem) {
        return false;
    }

    @Override
    public List<MenuItem> retrieveMenuItems() {
        return List.of();
    }

    @Override
    public MenuItem findById(long id) {
        return null;
    }

    @Override
    public boolean deleteMenuItem(long id) {
        return false;
    }

    @Override
    public boolean updateMenuItem(MenuItem menuItem) {
        return false;
    }
}
