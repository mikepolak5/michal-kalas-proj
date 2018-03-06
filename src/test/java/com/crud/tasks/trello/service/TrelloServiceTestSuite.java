package com.crud.tasks.trello.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCardDto;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Test
    public void createdTrelloCardTest() {
        //Given
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "test", "test");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "up", "1");
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //When
        String name = trelloService.createdTrelloCard(trelloCardDto).getName();

        //Then
        Assert.assertEquals("test", name);
    }
}
