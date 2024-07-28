-- auto Generated on 2024-07-29
-- DROP TABLE IF EXISTS overview;
CREATE TABLE overview(
	id VARCHAR (50) NOT NULL COMMENT 'ID',
	url VARCHAR (50) NOT NULL DEFAULT '' COMMENT '网址',
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '名字',
	chinese_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '中文名',
	cover VARCHAR (50) NOT NULL DEFAULT '' COMMENT '封面图',
	summary VARCHAR (50) NOT NULL DEFAULT '' COMMENT '简介',
	score VARCHAR (50) NOT NULL DEFAULT '' COMMENT '评分',
	episode INT (11) NOT NULL DEFAULT -1 COMMENT '话数',
	start_date VARCHAR (50) NOT NULL DEFAULT '' COMMENT '放送开始',
	week_day VARCHAR (50) NOT NULL DEFAULT '' COMMENT '放送星期',
	original VARCHAR (50) NOT NULL DEFAULT '' COMMENT '原作',
	director VARCHAR (50) NOT NULL DEFAULT '' COMMENT '导演',
	scriptwriter VARCHAR (50) NOT NULL DEFAULT '' COMMENT '脚本',
	storyboard VARCHAR (50) NOT NULL DEFAULT '' COMMENT '分镜',
	director_of_photography VARCHAR (50) NOT NULL DEFAULT '' COMMENT '演出',
	music VARCHAR (50) NOT NULL DEFAULT '' COMMENT '音乐',
	character_design VARCHAR (50) NOT NULL DEFAULT '' COMMENT '人物设定',
	series_composition VARCHAR (50) NOT NULL DEFAULT '' COMMENT '系列构成',
	art_director VARCHAR (50) NOT NULL DEFAULT '' COMMENT '美术监督',
	color_design VARCHAR (50) NOT NULL DEFAULT '' COMMENT '色彩设计',
	chief_animation_director VARCHAR (50) NOT NULL DEFAULT '' COMMENT '总作画监督',
	animation_director VARCHAR (50) NOT NULL DEFAULT '' COMMENT '作画监督',
	photography_director VARCHAR (50) NOT NULL DEFAULT '' COMMENT '摄影监督',
	prop_design VARCHAR (50) NOT NULL DEFAULT '' COMMENT '道具设计',
	editing VARCHAR (50) NOT NULL DEFAULT '' COMMENT '剪辑',
	theme_song_arrangement VARCHAR (50) NOT NULL DEFAULT '' COMMENT '主题歌编曲',
	theme_song_composition VARCHAR (50) NOT NULL DEFAULT '' COMMENT '主题歌作曲',
	theme_song_lyrics VARCHAR (50) NOT NULL DEFAULT '' COMMENT '主题歌作词',
	theme_song_performance VARCHAR (50) NOT NULL DEFAULT '' COMMENT '主题歌演出',
	planning VARCHAR (50) NOT NULL DEFAULT '' COMMENT '企画',
	production_management VARCHAR (50) NOT NULL DEFAULT '' COMMENT '制作管理',
	production VARCHAR (50) NOT NULL DEFAULT '' COMMENT '製作',
	sound_director VARCHAR (50) NOT NULL DEFAULT '' COMMENT '音响监督',
	sound VARCHAR (50) NOT NULL DEFAULT '' COMMENT '音响',
	sound_effects VARCHAR (50) NOT NULL DEFAULT '' COMMENT '音效',
	special_effects VARCHAR (50) NOT NULL DEFAULT '' COMMENT '特效',
	executive_producer VARCHAR (50) NOT NULL DEFAULT '' COMMENT '执行制片人',
	producer VARCHAR (50) NOT NULL DEFAULT '' COMMENT '制片人',
	music_production VARCHAR (50) NOT NULL DEFAULT '' COMMENT '音乐制作',
	animation_production VARCHAR (50) NOT NULL DEFAULT '' COMMENT '动画制作',
	art_design VARCHAR (50) NOT NULL DEFAULT '' COMMENT '美术设计',
	opening_ending_storyboard VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'OP・ED 分镜',
	three_dimensional_computer_graphics VARCHAR (50) NOT NULL DEFAULT '' COMMENT '3DCG',
	cooperation VARCHAR (50) NOT NULL DEFAULT '' COMMENT '协力',
	`alias` VARCHAR (50) NOT NULL DEFAULT '' COMMENT '别名',
	official_website VARCHAR (50) NOT NULL DEFAULT '' COMMENT '官方网站',
	tv_station VARCHAR (50) NOT NULL DEFAULT '' COMMENT '播放电视台',
	play_end VARCHAR (50) NOT NULL DEFAULT '' COMMENT '播放结束',
	copyright VARCHAR (50) NOT NULL DEFAULT '' COMMENT '版权',
	music_producer VARCHAR (50) NOT NULL DEFAULT '' COMMENT '音乐制作人',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'overview';