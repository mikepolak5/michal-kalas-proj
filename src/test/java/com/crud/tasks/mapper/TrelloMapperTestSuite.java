package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "test_list", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("test_board", "1", trelloListDtos);
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(trelloBoardDto);

        //When
        String getBoardName = trelloMapper.mapToBoards(trelloBoardDtos).get(0).getName();

        //Then
        Assert.assertEquals(1, trelloBoardDtos.size());
        Assert.assertEquals("test_board", getBoardName);
        Assert.assertEquals("1", trelloBoardDtos.get(0).getId());
    }
    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("1", "test_list", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("1", "1", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //When
        String getBoardName = trelloMapper.mapToBoardsDto(trelloBoards).get(0).getName();

        //Then
        Assert.assertEquals(1, trelloBoards.size());
        Assert.assertEquals("1", getBoardName);
        Assert.assertEquals("1", trelloBoards.get(0).getId());
    }
    @Test
    public void mapToListTest() {
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1", "test_list", false);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto);

        //When
        String getName = trelloMapper.mapToList(trelloListDtos).get(0).getName();
        String getId = trelloMapper.mapToList(trelloListDtos).get(0).getId();

        //Then
        Assert.assertEquals("test_list", getName);
        Assert.assertEquals("1", getId);
    }
    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("1", "test_list", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        //When
        String getName = trelloMapper.mapToListDto(trelloLists).get(0).getName();
        String getId = trelloMapper.mapToListDto(trelloLists).get(0).getId();

        //Then
        Assert.assertEquals("test_list", getName);
        Assert.assertEquals("1", getId);
    }
    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test_card", "card", "d", "1");

        //When
        trelloMapper.mapToCard(trelloCardDto);
        String getName = trelloMapper.mapToCard(trelloCardDto).getName();
        String getDesc = trelloMapper.mapToCard(trelloCardDto).getDescription();
        String getId = trelloMapper.mapToCard(trelloCardDto).getListId();
        String getPos = trelloMapper.mapToCard(trelloCardDto).getPos();

        //Then
        Assert.assertEquals("test_card", getName);
        Assert.assertEquals("card", getDesc);
        Assert.assertEquals("1", getId);
        Assert.assertEquals("d", getPos);
    }
    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test_card", "card", "d", "1");

        //When
        trelloMapper.mapToCardDto(trelloCard);
        String getName = trelloMapper.mapToCardDto(trelloCard).getName();
        String getDesc = trelloMapper.mapToCardDto(trelloCard).getDescription();
        String getId = trelloMapper.mapToCardDto(trelloCard).getListId();
        String getPos = trelloMapper.mapToCardDto(trelloCard).getPos();

        //Then
        Assert.assertEquals("test_card", getName);
        Assert.assertEquals("card", getDesc);
        Assert.assertEquals("1", getId);
        Assert.assertEquals("d", getPos);
    }
}
