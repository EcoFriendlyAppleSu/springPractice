package hello.core.member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    // default로 hashCode를 비교하기 때문에 같은 객체라면 equals(), hashCode()를 사용하지 않아도 된다.
    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
