package jpabook.jpabook;

import jakarta.transaction.Transactional;
import jpabook.jpabook.domain.Member;
import jpabook.jpabook.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void testMember() throws Exception{
        // given
        Member member = new Member();
        member.setUsername("memberA");
        // when
        long saveId = memberRepository.save(member);
        Member findmember = memberRepository.find(saveId);
        // then
        Assertions.assertThat(findmember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findmember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findmember).isEqualTo(member);

    }

}