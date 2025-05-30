package com.shreya.hibernate.service.impl;

import com.shreya.hibernate.exception.MenuItemDeletionException;
import com.shreya.hibernate.exception.MenuItemNotFoundException;
import com.shreya.hibernate.exception.MenuItemUpdateException;
import com.shreya.hibernate.model.MenuItem;
import com.shreya.hibernate.repository.MenuItemRepository;
import com.shreya.hibernate.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final Logger log = LoggerFactory.getLogger(MenuItemServiceImpl.class);

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public void addMenuItem(MenuItem menuItem) throws SQLException {
        log.info("Saving menuItem {}", menuItem);
        menuItemRepository.addMenuItem(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        log.info("Fetching all menuItems");
        return menuItemRepository.retrieveMenuItems();
    }

    @Override
    public MenuItem getMenuItemById(long id) {
        log.info("Fetching menu item by id: {}", id);
        MenuItem menuItem = menuItemRepository.findById(id);
        if (menuItem == null) {
            throw new MenuItemNotFoundException("MenuItem not found with id: " + id);
        }
        return menuItem;
    }

    @Override
    public void deleteMenuItem(long id) {
        log.info("Deleting menuItem with id: {}", id);
        boolean deleted = menuItemRepository.deleteMenuItem(id);
        if (!deleted) {
            throw new MenuItemDeletionException("Failed to delete MenuItem with id: " + id);
        }
    }

    @Override
    public void updateMenuItem(MenuItem menuItem) {
        log.info("Updating menuItem {}", menuItem);
        boolean updated = menuItemRepository.updateMenuItem(menuItem);
        if (!updated) {
            throw new MenuItemUpdateException("Failed to update MenuItem with id: " + menuItem.getId());
        }
    }
}
