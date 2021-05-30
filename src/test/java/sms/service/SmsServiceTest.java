package sms.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sms.entity.Msg;
import sms.reporistory.MsgReporistory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SmsServiceTest {

    @Mock
    private MsgReporistory msgReporistory;
    private SmsService underTest;

    @BeforeEach
    void setUp(){
        underTest = new SmsService(msgReporistory);
    }


    @Test
    void canGetMSG() {


    }

    @Test
    void addHoursToJavaUtilDate() {
    }
}
