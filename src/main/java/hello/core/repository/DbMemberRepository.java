package hello.core.repository;

import hello.core.domain.member.Member;

public class DbMemberRepository implements MemberRepository {

    @Override
    public void save(Member member) {

    }

    @Override
    public Member findById(Long memberId) {
        return null;
    }
}
