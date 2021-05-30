package sms.reporistory;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sms.entity.Msg;

public interface MsgReporistory extends CrudRepository<Msg,Long> {

	List<Msg> findByFromAndTo(String from,String to);
}
