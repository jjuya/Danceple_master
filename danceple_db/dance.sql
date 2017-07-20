
/* Drop Tables */

DROP TABLE tb_Apply CASCADE CONSTRAINTS;
DROP TABLE tb_Teacher CASCADE CONSTRAINTS;
DROP TABLE tb_Genre CASCADE CONSTRAINTS;
DROP TABLE tb_User CASCADE CONSTRAINTS;
DROP TABLE tb_Grade CASCADE CONSTRAINTS;
DROP TABLE tb_Season CASCADE CONSTRAINTS;
DROP TABLE tb_Team CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE seq_season;
DROP SEQUENCE seq_teacher;




/* Create Sequences */

CREATE SEQUENCE seq_season;
CREATE SEQUENCE seq_teacher;



/* Create Tables */

CREATE TABLE tb_Apply
(
	userid varchar2(20) NOT NULL,
	teamid varchar2(6) NOT NULL,
	genre1 varchar2(6) NOT NULL,
	genre2 varchar2(6),
	genre3 varchar2(6),
	-- 시즌 인덱싱
	seasonid number DEFAULT 0 NOT NULL,
	teamother varchar2(100),
	PRIMARY KEY (userid, teamid)
);


CREATE TABLE tb_Genre
(
	genreid varchar2(6) NOT NULL,
	genrename varchar2(20) NOT NULL,
	-- 관련 영상이나 설명 링크
	genreurl varchar2(50),
	PRIMARY KEY (genreid)
);


CREATE TABLE tb_Grade
(
	gradeid number NOT NULL,
	gradename varchar2(11) NOT NULL,
	PRIMARY KEY (gradeid)
);


CREATE TABLE tb_Season
(
	-- 시즌 인덱싱
	seasonid number DEFAULT 0 NOT NULL,
	-- 시즌의 시작 월.
	-- (간간히 뛰는 달이 있음.)
	snmonth varchar2(2) NOT NULL,
	-- YYYY/MM/dd
	startdate date NOT NULL,
	-- YYYY/MM/DD
	enddate date NOT NULL,
	-- YYYY/MM/DD
	-- 매 시즌 프로젝트 실행일자
	projectdate date,
	-- 프로젝트 세부내용
	projectdesc varchar2(50),
	PRIMARY KEY (seasonid)
);


CREATE TABLE tb_Teacher
(
	teacherid number NOT NULL,
	teachername varchar2(50) NOT NULL,
	genreid varchar2(6) NOT NULL,
	teamid varchar2(6) NOT NULL,
	-- 시즌 인덱싱
	seasonid number DEFAULT 0 NOT NULL,
	PRIMARY KEY (teacherid)
);


CREATE TABLE tb_Team
(
	teamid varchar2(6) NOT NULL,
	teamname varchar2(20) NOT NULL,
	--  금요일/ 토요일 / 일요일
	-- 
	teamday varchar2(10) NOT NULL,
	location varchar2(10) NOT NULL,
	-- HH:MM~HH:MM
	maintime varchar2(11),
	-- HH:MM~HH:MM
	pretime varchar2(11),
	-- Team 소개 페이지 연결
	teamurl varchar2(50),
	PRIMARY KEY (teamid)
);


CREATE TABLE tb_User
(
	userid varchar2(20) NOT NULL,
	name varchar2(30) NOT NULL,
	phone varchar2(12) NOT NULL,
	email varchar2(50) NOT NULL,
	gradeid number NOT NULL,
	userpwd varchar2(20) NOT NULL,
	gender varchar2(5) NOT NULL,
	-- 1 : 시즌 신청 패널티 있는 경우.
	-- 0 : 정상
	-- 
	-- 관리자가 설정할 수 있게
	penalty number DEFAULT 0 NOT NULL,
	-- 현재 어떤 팀 소속인지 확인하기 위해 참조.
	teamid varchar2(6) NOT NULL,
	birthday date,
	PRIMARY KEY (userid)
);



/* Create Foreign Keys */

ALTER TABLE tb_Apply
	ADD FOREIGN KEY (genre3)
	REFERENCES tb_Genre (genreid)
;


ALTER TABLE tb_Apply
	ADD FOREIGN KEY (genre1)
	REFERENCES tb_Genre (genreid)
;


ALTER TABLE tb_Apply
	ADD FOREIGN KEY (genre2)
	REFERENCES tb_Genre (genreid)
;


ALTER TABLE tb_Teacher
	ADD FOREIGN KEY (genreid)
	REFERENCES tb_Genre (genreid)
;


ALTER TABLE tb_User
	ADD FOREIGN KEY (gradeid)
	REFERENCES tb_Grade (gradeid)
;


ALTER TABLE tb_Apply
	ADD FOREIGN KEY (seasonid)
	REFERENCES tb_Season (seasonid)
;


ALTER TABLE tb_Teacher
	ADD FOREIGN KEY (seasonid)
	REFERENCES tb_Season (seasonid)
;


ALTER TABLE tb_Apply
	ADD FOREIGN KEY (teamid)
	REFERENCES tb_Team (teamid)
;


ALTER TABLE tb_Teacher
	ADD FOREIGN KEY (teamid)
	REFERENCES tb_Team (teamid)
;


ALTER TABLE tb_User
	ADD FOREIGN KEY (teamid)
	REFERENCES tb_Team (teamid)
;


ALTER TABLE tb_Apply
	ADD FOREIGN KEY (userid)
	REFERENCES tb_User (userid)
;



/* Comments */

COMMENT ON COLUMN tb_Apply.seasonid IS '시즌 인덱싱';
COMMENT ON COLUMN tb_Genre.genreurl IS '관련 영상이나 설명 링크';
COMMENT ON COLUMN tb_Season.seasonid IS '시즌 인덱싱';
COMMENT ON COLUMN tb_Season.snmonth IS '시즌의 시작 월.
(간간히 뛰는 달이 있음.)';
COMMENT ON COLUMN tb_Season.startdate IS 'YYYY/MM/dd';
COMMENT ON COLUMN tb_Season.enddate IS 'YYYY/MM/DD';
COMMENT ON COLUMN tb_Season.projectdate IS 'YYYY/MM/DD
매 시즌 프로젝트 실행일자';
COMMENT ON COLUMN tb_Season.projectdesc IS '프로젝트 세부내용';
COMMENT ON COLUMN tb_Teacher.seasonid IS '시즌 인덱싱';
COMMENT ON COLUMN tb_Team.teamday IS ' 금요일/ 토요일 / 일요일
';
COMMENT ON COLUMN tb_Team.maintime IS 'HH:MM~HH:MM';
COMMENT ON COLUMN tb_Team.pretime IS 'HH:MM~HH:MM';
COMMENT ON COLUMN tb_Team.teamurl IS 'Team 소개 페이지 연결';
COMMENT ON COLUMN tb_User.penalty IS '1 : 시즌 신청 패널티 있는 경우.
0 : 정상

관리자가 설정할 수 있게';
COMMENT ON COLUMN tb_User.teamid IS '현재 어떤 팀 소속인지 확인하기 위해 참조.';

insert into tb_genre (genreid, genrename, genreurl)values (0,'Anything is OK!','http://www.naver.com');
insert into tb_genre (genreid, genrename, genreurl)values (1,'Voguing Dance','http://www.google.com');
insert into tb_genre (genreid, genrename, genreurl)values (2,'Dab Dance','http://www.naver.com');
insert into tb_genre (genreid, genrename, genreurl)values (3,'K-pop Dance','http://www.google.com');
insert into tb_genre (genreid, genrename, genreurl)values (4,'House Dance','http://www.naver.com');
insert into tb_genre (genreid, genrename, genreurl)values (5,'Urban Dance','http://www.daum.net');
insert into tb_genre (genreid, genrename, genreurl)values (6,'Poppin Dance','http://www.naver.com');
insert into tb_genre (genreid, genrename, genreurl)values (7,'Jazz Dance','http://www.google.com');
insert into tb_genre (genreid, genrename, genreurl)values (8,'Locking Dance','http://www.naver.com');
insert into tb_genre (genreid, genrename, genreurl)values (9,'Hiphop Dance','http://www.google.com');
insert into tb_genre (genreid, genrename, genreurl)values (10,'B-boy Dance','http://www.naver.com');
insert into tb_genre (genreid, genrename, genreurl)values (11,'Soul Dance','http://www.naver.com');
insert into tb_genre (genreid, genrename, genreurl)values (12,'Waacking Dance','http://www.daum.net');

select * from tb_genre;



insert into tb_season(seasonid,snmonth,startdate,enddate,projectdate, projectdesc) 
values(1,'6','2017/06/12','2017/06/24','2017/06/25','가나다라마바사아자차카타파하');
insert into tb_season(seasonid,snmonth,startdate,enddate,projectdate, projectdesc) 
values(2,'7','2017/07/17','2017/07/28','2017/07/28','CRUWD 팀의 미니 프로젝입니다.');

select * from tb_season;


insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000001','꿀토끼','토요일','혜화','12:00~14:00','14:00~18:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000002','유레카','토요일','사당','12:00~14:00','14:00~18:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000003','크리티컬','토요일','사당','16:00~18:00','18:00~22:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000004','일단만나','일요일','혜화','12:00~14:00','14:00~18:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000005','새싹','일요일','사당','12:00~14:00','14:00~18:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000006','씨앗데이','일요일','신촌','13:00~15:00','15:00~19:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000007','일루와','일요일','사당','16:00~18:00','18:00~22:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000008','사금기','금요일','사당','19:00~19:45','19:45~23:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000009','방토기','토요일','내방','13:00~15:00','15:00~19:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000010','혜토기','토요일','혜화','13:00~15:00','15:00~19:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000011','혜토야','토요일','혜화','16:00~18:00','18:00~22:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000012','혜일기','일요일','혜화','13:00~15:00','15:00~19:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000013','신일기','일요일','신촌','12:00~14:00','14:00~18:00','#');
insert into tb_team (teamid, teamname, teamday, location,maintime,pretime,teamurl)values('000014','방일기','일요일','내방','12:00~14:00','14:00~18:00','#');

select * from tb_team;

insert into tb_grade (gradeid, gradename) values(1, '신규');
insert into tb_grade (gradeid, gradename) values(2, '기존');
insert into tb_grade (gradeid, gradename) values(3, '복귀');
insert into tb_grade (gradeid, gradename) values(4, '헬퍼');

select * from tb_grade;



