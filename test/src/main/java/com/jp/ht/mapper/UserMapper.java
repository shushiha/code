package com.jp.ht.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jp.ht.pojo.User;
@Mapper
public interface UserMapper {
	//検索
	@Select("select * from users where login_id=#{loginId}")
	User findByUserId(Integer loginId);
	//追加
	@Insert("insert into users(personal_number, last_name_kanji, first_name_kanji, last_name_kana,"
			+ " first_name_kana, postal_code, address1, address2, address3,"
			+ " phone_type, phone1, phone2, birth_date, age, email, registration_date,"
			+ " registrant_name, update_date, updater_name)"+
	         " values(#{personalNumber}, #{lastNameKanji}, #{firstNameKanji}, #{lastNameKana}, #{firstNameKana},"
	         + " #{postalCode}, #{address1}, #{address2}, #{address3}, #{phoneType}, #{phone1}, #{phone2},"
	         + " #{birthDate}, #{age}, #{email},now(), #{registrantName},now(),"
	         + " #{updaterName})")
	void add(User user);
	@Update("update users set personal_number=#{personalNumber} ,last_name_kanji=#{lastNameKanji},first_name_kanji=#{firstNameKanji},last_name_kana=#{lastNameKana},"
			+ " first_name_kana=#{firstNameKana}, postal_code=#{postalCode}, address1=#{address1}, "
			+ "address2=#{address2}, address3=#{address3}, phone_type=#{phoneType},"
			+ " phone1=#{phone1}, phone2=#{phone2}, birth_date=#{birthDate}, age=#{age}, email=#{email},"
			+ " update_date=now(),updater_name= #{updaterName} where login_id=#{loginId}")
	void update(User user);
	
	


}
