package com.example.ReviewsProyecto.service.impl;



import com.example.ReviewsProyecto.dao.ItemDAO;
import com.example.ReviewsProyecto.dao.impl.ORMItemDAO;
import com.example.ReviewsProyecto.dto.ItemDTO;
import com.example.ReviewsProyecto.dto.ReviewDTO;
import com.example.ReviewsProyecto.mapper.ItemMapper;
import com.example.ReviewsProyecto.model.Item;
import com.example.ReviewsProyecto.model.Review;
import com.example.ReviewsProyecto.service.ItemService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    @Override
    public List<ItemDTO> obtenerTodos() throws SQLException {
        return null;
    }

    @Override
    public List<ItemDTO> obtenerPeliculas() throws SQLException {
        ItemDAO idao = new ORMItemDAO();
        List<Item>items = idao.listarPorTipo("Pelicula");
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for(Item item:items){
            itemDTOS.add(ItemMapper.modelDTO(item));

        }
        return itemDTOS;
    }

    @Override
    public List<ItemDTO> obtenerSeries() throws SQLException {
        ItemDAO idao = new ORMItemDAO();
        List<Item>items = idao.listarPorTipo("Serie");
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for(Item item:items){
            itemDTOS.add(ItemMapper.modelDTO(item));
        }
        return itemDTOS;    }

    @Override
    public List<ItemDTO> obtenerLibros() throws SQLException {
        ItemDAO idao = new ORMItemDAO();
        List<Item>items = idao.listarPorTipo("Libro");
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for(Item item:items){
            itemDTOS.add(ItemMapper.modelDTO(item));
        }
        return itemDTOS;    }

    @Override
    public List<ItemDTO> obtenerVideojuegos() throws SQLException {
        ItemDAO idao = new ORMItemDAO();
        List<Item>items = idao.listarPorTipo("juego");
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for(Item item:items){
            itemDTOS.add(ItemMapper.modelDTO(item));
        }
        return itemDTOS;    }

    @Override
    public List<ItemDTO> obtenerMusica() throws SQLException {
        ItemDAO idao = new ORMItemDAO();
        List<Item>items = idao.listarPorTipo("Musica");
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for(Item item:items){
            itemDTOS.add(ItemMapper.modelDTO(item));
        }
        return itemDTOS;    }

    @Override
    public ItemDTO obtenerPorId(int id) throws SQLException {
        ItemDAO idao = new ORMItemDAO();
        return ItemMapper.modelDTO(idao.obtenerItem(id));
    }
}
