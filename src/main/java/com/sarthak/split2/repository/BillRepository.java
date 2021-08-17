package com.sarthak.split2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

import com.sarthak.split2.entity.Bill;
import com.sarthak.split2.entity.Group;
import com.sarthak.split2.pojos.UserAmount;
import com.sarthak.split2.pojos.Users_groups;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	

	
	//working
	@Query(value="Select * from Bill where gid=?1 ",nativeQuery = true)
	List<Bill> findBygroup(long gid);
	
	
	@Query(value="Select b from Bill b where b.description like %:des%")
	List<Bill> findBydes(@Param("des")String des);

	@Query(value="Select b from Bill b where b.user like %:uid%")
	List<Bill> findByuser(@Param("uid")long uid);
	
//	@Query(value="select new com.sarthak.split2.pojos.UserAmount(users_groups.uid, bill.amount) from users_groups left join bill on users_groups.uid=bill.payed_by_uid and users_groups.gid=bill.gid" )
//	public List<UserAmount> getlist();
	
	//left join example
	//("SELECT p FROM Pilot p LEFT JOIN FETCH p.playerShips s ON s.active = false WHERE p.nickname = (:nickname)......//ON b.user.id=u.id
	//triple join example
	// "SELECT u " +"FROM usages u " +"LEFT JOIN u.subscriptionPeriod p " +"LEFT JOIN p.subscription s " + "WHERE u.paymentStatus = 'NEW' AND s.remoteId = :remoteId"
	
//	@Query(value="select new com.sarthak.split2.pojos.UserAmount(u.id,b.amount) from User u  join u.bills b ")
//	public List<UserAmount> getlist();
	
	
	@Query(value="select new com.sarthak.split2.pojos.Users_groups(u.id,g.description) from User u left join u.groups g ")
	public List<Users_groups> getusergroup();
	
	@Query(value="select new com.sarthak.split2.pojos.UserAmount(u.id,g.g_id,case when b.amount is null then 0.0 else b.amount end) from User u  join u.groups g left join u.bills b ON b.user.id=u.id and b.group.g_id=g.g_id where g.g_id=?1")
	public List<UserAmount> getlist2(long gid);

}
