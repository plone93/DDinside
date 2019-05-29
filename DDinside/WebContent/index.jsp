<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="header.jsp"%>


<%
	String message = (String)request.getAttribute("message");
%>
<c:if test="${message ne null}">
	<script>
		alert("<%=message%>");
	</script>
</c:if>

<div class="cate_wrap">
	<!--table width="100%" cellpadding="0" cellspacing="0" border="0"-->

	<div class="cate_box">
		<!--td class="board_study" style=""-->
		<div class="section_cate board_study">

			<!--div class="section_board_study"-->

			<h4 class="cate_tit">
				掲示板開設・お問い合わせ<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 90px;">
					<li class=""><a
						<c:set var="new_board" value="開設申込"/>
				        href="controller?command=BoardList&board_id=${new_board}"
						target="_parent"> 開設申込 </a></li>
					<li class=""><a
						<c:set var="question" value="お問い合わせ"/>
				        href="controller?command=BoardList&board_id=${question}"
						target="_parent"> お問い合わせ </a></li>
				</ul>

			</div>
		</div>



		<!--td class="new_gallery" style="position:relative;padding-bottom:140px"-->
		<div class="section_cate new_gallery">

			<!--div class="section_new_gallery"-->

			<h4 class="cate_tit">
				新規掲示板<span class="list_num"></span><span><em class="blind"></em><em
					class="sp_img icon_new"></em></span>
			</h4>
			<div class="cate">
				<ul style="height: 90px;">

				</ul>
			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="special" style=""-->
		<div class="section_cate special">

			<!--div class="section_special"-->

			<h4 class="cate_tit">
				スペシャル<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li class=""><a
						<c:set var="best" value="高評価"/>
				        href="controller?command=BoardList&board_id=${best}"
						target="_parent"> 高評価 </a></li>
					<li class=""><a
						<c:set var="worst" value="低評価"/>
				        href="controller?command=BoardList&board_id=${worst}"
						target="_parent"> 低評価 </a></li>
					<li class=""><a
						<c:set var="aho" value="アホ"/>
				        href="controller?command=BoardList&board_id=${aho}"
						target="_parent"> アホ </a></li>	
				</ul>


			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="fashion" style=""-->
		<div class="section_cate fashion">

			<!--div class="section_fashion"-->

			<h4 class="cate_tit">
				ファッション<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li class="twoline"><a
						<c:set var="fashion_new1" value="上着 "/>
				        href="controller?command=BoardList&board_id=${fashion_new1}"
						target="_parent"> 上着 </a></li>
					<li class="twoline"><a 
						<c:set var="pants" value="下着"/>
				        href="controller?command=BoardList&board_id=${pants}"
						target="_parent">下着</a></li>
					<li class="twoline"><a 
						<c:set var="watch" value="時計 "/>
				        href="controller?command=BoardList&board_id=${watch}"
						target="_parent"> 時計 </a></li>
					<li class="twoline"><a
						<c:set var="footwear" value="靴"/>
				        href="controller?command=BoardList&board_id=${footwear}" 
						target="_parent">靴</a></li>
					<li><a 
						<c:set var="fashion_acc" value="眼鏡"/>
				        href="controller?command=BoardList&board_id=${fashion_acc}" 
						target="_parent"> 眼鏡</a></li>
					<li><a 
						<c:set var="tattoo" value="入れ墨"/>
				        href="controller?command=BoardList&board_id=${tattoo}" 
						target="_parent"> 入れ墨</a></li>
					<li><a 
						<c:set var="cosmetic" value="香水、化粧品"/>
				        href="controller?command=BoardList&board_id=${cosmetic}" 
						target="_parent"> 香水、化粧品</a></li>
					<li><a 	
						<c:set var="hair" value="髪型"/>
				        href="controller?command=BoardList&board_id=${hair}" 
						target="_parent"> 髪型</a></li>
				</ul>
			</div>
			<h4 class="cate_tit">
				生き物<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li class="twoline"><a 
						<c:set var="tree" value="植物"/>
				        href="controller?command=BoardList&board_id=${tree}" 
						target="_parent"> 植物 </a></li>
					<li><a 
						<c:set var="animal" value="動物"/>
				        href="controller?command=BoardList&board_id=${animal}" 
						target="_parent"> 動物</a></li>
					<li class="twoline"><a 
						<c:set var="dog" value="犬"/>
				        href="controller?command=BoardList&board_id=${dog}" 
						target="_parent">犬</a></li>
					<li class="twoline"><a 
						<c:set var="insect" value="昆虫"/>
				        href="controller?command=BoardList&board_id=${insect}" 
						target="_parent"> 昆虫 </a></li>
					<li class="twoline"><a 
						<c:set var="cat" value="猫"/>
				        href="controller?command=BoardList&board_id=${cat}" 
						target="_parent">猫</a></li>
					<li><a 
						<c:set var="fish" value="魚"/>
				        href="controller?command=BoardList&board_id=${fish}"
						target="_parent"> 魚</a></li>
					<li><a 
						<c:set var="reptile" value="爬虫類, 両生類"/>
				        href="controller?command=BoardList&board_id=${reptile}"
						target="_parent"> 爬虫類, 両生類</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="issue" style=""-->
		<div class="section_cate issue">

			<!--div class="section_issue"-->

			<h4 class="cate_tit">
				話題<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li><a 
						<c:set var="accident" value="メチャクチャ"/>
				        href="controller?command=BoardList&board_id=${accident}" 
						target="_parent">メチャクチャ </a></li>
					<li><a 
						<c:set var="news_new" value="政治、社会"/>
				        href="controller?command=BoardList&board_id=${news_new}" 
						target="_parent"> 政治、社会</a></li>
					<li><a 
						<c:set var="earthquake" value="地震"/>
				        href="controller?command=BoardList&board_id=${earthquake}"
						target="_parent"> 地震</a></li>
				</ul>
				<!--p class='list_line' style="margin:10px 0px 10px 0px;border-top:1px dashed #aaa;">gg</p-->
				<!--div class="section_last_issue"><strong>지난 이슈 <button type="button" class="btn_cate_more" data-lyr = "Layer_1259"  onClick="javascript:show_layer('Layer_1259')"><span class="blind">더보기</span><em class="sp_img icon_listmore"></em></button></strong></div-->
			</div>
			<h4 class="cate_tit">
				過ぎた話題
			</h4>
			<!--p class='list_line' style="margin:10px 0px 10px 0px;border-top:border-top:1px dashed #aaa;"></p-->
			<div class="cate">
				<ul style="">
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="travel_scene" style=""-->
		<div class="section_cate travel_scene">

			<!--div class="section_travel_scene"-->

			<h4 class="cate_tit">
				旅行・風景<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li class=""><a
						<c:set var="travel_japan" value="日本"/>
				        href="controller?command=BoardList&board_id=${travel_japan}"
						target="_parent"> 日本 </a></li>
					<li class=""><a
						<c:set var="travel_koria" value="韓国"/>
				        href="controller?command=BoardList&board_id=${travel_koria}"
						target="_parent"> 韓国 </a></li>
					<li class=""><a
						<c:set var="travel_china" value="中国"/>
				        href="controller?command=BoardList&board_id=${travel_china}"
						target="_parent"> 中国 </a></li>
					<li class=""><a
						<c:set var="travel_america" value="アメリカ"/>
				        href="controller?command=BoardList&board_id=${travel_america}"
						target="_parent"> アメリカ </a></li>
					<li class=""><a
						<c:set var="travel_asia" value="東南アジア"/>
				        href="controller?command=BoardList&board_id=${travel_asia}"
						target="_parent">東南アジア</a></li>
					<li><a 
						<c:set var="travel_europe" value="ヨーロッパ"/>
				        href="controller?command=BoardList&board_id=${travel_europe}"
						target="_parent"> ヨーロッパ</a></li>
					<li><a 
						<c:set var="city" value="都市"/>
				        href="controller?command=BoardList&board_id=${city}"
						target="_parent"> 都市</a></li>
				</ul>
				<!--p class='list_line' style="margin:10px 0px 10px 0px;border-top:1px dashed #aaa;">gg</p-->
			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="food" style=""-->
		<div class="section_cate food">

			<!--div class="section_food"-->

			<h4 class="cate_tit">
				食べ物<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li class="twoline"><a 
						<c:set var="alcohol" value="酒"/>
				        href="controller?command=BoardList&board_id=${alcohol}"
						target="_parent"> 酒 </a></li>
					<li class="twoline"><a
						<c:set var="food_noodle" value="麺"/>
				        href="controller?command=BoardList&board_id=${food_noodle}"
						target="_parent">麺</a></li>
					<li class="twoline"><a 
						<c:set var="sweets" value="お菓子"/>
				        href="controller?command=BoardList&board_id=${sweets}"
						target="_parent"> お菓子</a></li>
					<li class="twoline"><a 
						<c:set var="chicken" value="チキン"/>
				        href="controller?command=BoardList&board_id=${chicken}"
						target="_parent">チキン</a></li>
					<li><a 
						<c:set var="tea" value="飲み物"/>
				        href="controller?command=BoardList&board_id=${tea}"
						target="_parent"> 飲み物</a></li>
					<li><a 
						<c:set var="pizza" value="ピーザ"/>
				        href="controller?command=BoardList&board_id=${pizza}"
						target="_parent"> ピーザ</a></li>
					<li><a 
						<c:set var="cs" value="コンビニ"/>
				        href="controller?command=BoardList&board_id=${cs}"
						target="_parent"> コンビニ</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>


	</div>
	<!--zz-->
	<div class="cate_box">
		<!--td class="dc_pain4" style=""-->
		<div class="section_cate dc_pain4">

			<!--div class="section_dc_pain4"-->

			<h4 class="cate_tit">
				デジタル<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 156px;">
					<li><a 
						<c:set var="smartphone" value="スマホ"/>
				        href="controller?command=BoardList&board_id=${smartphone}" 
						target="_parent"> スマホ</a></li>
					<li><a 
						<c:set var="tabletpc" value="タブレットPC"/>
				        href="controller?command=BoardList&board_id=${tabletpc}" 
						target="_parent"> タブレットPC</a></li>
					<li><a
						<c:set var="earphone" value="イヤホン、ヘットフォン"/>
				        href="controller?command=BoardList&board_id=${earphone}"  
						target="_parent"> イヤホン、ヘットフォン</a></li>
					<li><a 
						<c:set var="pc" value="パソコン"/>
				        href="controller?command=BoardList&board_id=${pc}"  
						target="_parent"> パソコン</a></li>
					<li><a 
						<c:set var="programming" value="プログラミング"/>
				        href="controller?command=BoardList&board_id=${programming}" 
						target="_parent"> プログラミング</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="composition" style=""-->
		<div class="section_cate composition">

			<!--div class="section_composition"-->

			<h4 class="cate_tit">
				合成<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 156px;">
					<li><a 
						<c:set var="edit" value="合成・編集"/>
				        href="controller?command=BoardList&board_id=${edit}" 
						target="_parent"> 合成・編集</a></li>
				</ul>
			</div>
			<h4 class="cate_tit">
				機関<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li><a 
						<c:set var="police" value="警察"/>
				        href="controller?command=BoardList&board_id=${police}" 
						target="_parent"> 警察</a></li>
				</ul>
			</div>
			<h4 class="cate_tit">
				試験<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li><a 
						<c:set var="exam_new" value="テスト"/>
				        href="controller?command=BoardList&board_id=${exam_new}" 
						target="_parent"> テスト</a></li>
					<li class="twoline"><a
						<c:set var="languageexam" value="言語"/>
				        href="controller?command=BoardList&board_id=${languageexam}" 
						target="_parent"> 言語 </a></li>
					<li class="twoline"><a 
						<c:set var="mathexam" value="数学"/>
				        href="controller?command=BoardList&board_id=${mathexam}" 
						target="_parent">数学</a></li>
					<li class="twoline"><a	
						<c:set var="societyexam" value="社会"/>
				        href="controller?command=BoardList&board_id=${societyexam}" 			
						target="_parent"> 社会 </a></li>
					<li class="twoline"><a
						<c:set var="scienceexam" value="科学"/>
				        href="controller?command=BoardList&board_id=${scienceexam}" 
						target="_parent">科学</a></li>
					<li class="twoline"><a
						<c:set var="englishexam" value="外国語"/>
				        href="controller?command=BoardList&board_id=${englishexam}" 
						target="_parent"> 外国語 </a></li>
					<li class="twoline"><a
						<c:set var="itlecture" value="ネット講義"/>
				        href="controller?command=BoardList&board_id=${itlecture}" 
						target="_parent">ネット講義</a></li>
					<li><a 
						<c:set var="readingroom" value="読書室"/>
				        href="controller?command=BoardList&board_id=${readingroom}" 
						target="_parent"> 読書室</a></li>
					<li><a 
						<c:set var="preparatoryschool" value="塾"/>
				        href="controller?command=BoardList&board_id=${preparatoryschool}" 
						target="_parent"> 塾</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="dc_pain1" style=""-->
		<div class="section_cate dc_pain1">

			<!--div class="section_dc_pain1"-->

			<h4 class="cate_tit">
				趣味<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 596px;">
					<li class=""><a 
						<c:set var="toy" value="玩具"/>
				        href="controller?command=BoardList&board_id=${toy}" 
						target="_parent"> 玩具 </a></li>
					<li class=""><a
						<c:set var="fantasy_new" value="ファンタジー"/>
				        href="controller?command=BoardList&board_id=${fantasy_new}" 
						target="_parent">ファンタジー</a></li>
					<li class=""><a
						<c:set var="comic_new1" value="스마트폰"/>
				        href="controller?command=BoardList&board_id=${comic_new1}" 
						target="_parent"> 漫画 </a></li>
					<li class=""><a 
						<c:set var="sphero" value="ウェブ漫画"/>
				        href="controller?command=BoardList&board_id=${sphero}" 
						target="_parent">ウェブ漫画</a></li>
					<li class=""><a 
						<c:set var="fishing" value="釣り"/>
				        href="controller?command=BoardList&board_id=${fishing}" 
						target="_parent"> 釣り </a></li>
					<li class=""><a 
						<c:set var="webtoon" value="碁"/>
				        href="controller?command=BoardList&board_id=${webtoon}" 
						target="_parent">碁</a></li>
					<li class=""><a 
						<c:set var="baduk" value="ヒーロー"/>
				        href="controller?command=BoardList&board_id=${baduk}" 
						target="_parent">ヒーロー</a></li>
					<li><a 
						<c:set var="ani1_new1" value="アニメ"/>
				        href="controller?command=BoardList&board_id=${ani1_new1}" 
						target="_parent"> アニメ</a><li>
					<li class="noimg"><a
						<c:set var="girlsundpanzer" value="ガールズアンドパンツァー"/>
				        href="controller?command=BoardList&board_id=${girlsundpanzer}" 
						target="_parent">- ガールズアンドパンツァー</a></li>
					<li class="noimg"><a 
						<c:set var="aikatsu" value="アイカツ"/>
				        href="controller?command=BoardList&board_id=${aikatsu}" 
						target="_parent">- アイカツ</a></li>
					<li class="noimg"><a 
						<c:set var="pripara" value="プリパラ"/>
				        href="controller?command=BoardList&board_id=${pripara}" 
						target="_parent">- プリパラ</a></li>
					<li class="noimg"><a 
						<c:set var="precure" value="プリキュア"/>
				        href="controller?command=BoardList&board_id=${precure}" 
						target="_parent">- プリキュア</a></li>
					<li class="noimg"><a 
						<c:set var="shingeki" value="進撃の巨人"/>
				        href="controller?command=BoardList&board_id=${shingeki}" 
						target="_parent">- 進撃の巨人</a></li>
					<li><a 
						<c:set var="america_ani" value="アニメーアメリカ"/>
				        href="controller?command=BoardList&board_id=${america_ani}" 
						target="_parent"> アニメーアメリカ</a></li>
					<li><a 
						<c:set var="theaterM" value="演劇"/>
				        href="controller?command=BoardList&board_id=${theaterM}" 
						target="_parent"> 演劇</a></li>
					<li><a 
						<c:set var="movie2" value="映画"/>
				        href="controller?command=BoardList&board_id=${movie2}" 
						target="_parent"> 映画</a></li>
					<li class="noimg"><a 
						<c:set var="yourname" value="君の名は"/>
				        href="controller?command=BoardList&board_id=${yourname}" 
						target="_parent">- 君の名は</a></li>
					<li class="noimg"><a 
						<c:set var="frozen" value="アナと雪の女王"/>
				        href="controller?command=BoardList&board_id=${frozen}" 
						target="_parent">- アナと雪の女王</a></li>
					<li><a 
						<c:set var="vocaloid" value="ボーカロイド"/>
				        href="controller?command=BoardList&board_id=${vocaloid}" 
						target="_parent"> ボーカロイド</a></li>
					<li class="twoline"><a 
						<c:set var="yjrs" value="女装"/>
				        href="controller?command=BoardList&board_id=${yjrs}" 
						target="_parent">女装</a></li>
					<li><a 
						<c:set var="web_fic" value="小説"/>
				        href="controller?command=BoardList&board_id=${web_fic}" 
						target="_parent"> 小説</a></li>
					<li><a 
						<c:set var="etc_g" value="デジカメ"/>
				        href="controller?command=BoardList&board_id=${etc_g}" 
						target="_parent"> デジカメ</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="dc_pain2" style=""-->
		<div class="section_cate dc_pain2">

			<!--div class="section_dc_pain2"-->

			<h4 class="cate_tit">
				学術<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 496px;">
					<li class="twoline"><a 
						<c:set var="history" value="歴史"/>
				        href="controller?command=BoardList&board_id=${history}" 
						target="_parent"> 歴史 </a></li>
					<li class="twoline"><a 
						<c:set var="english" value="英語"/>
				        href="controller?command=BoardList&board_id=${english}" 
						target="_parent">英語</a></li>
					<li class="twoline"><a 
						<c:set var="japanese" value="日本語"/>
				        href="controller?command=BoardList&board_id=${japanese}" 
						target="_parent">日本語 </a></li>
					<li class="twoline"><a
						<c:set var="mathematics" value="数学"/>
				        href="controller?command=BoardList&board_id=${mathematics}" 
						target="_parent">数学</a></li>
					<li class="twoline"><a
						<c:set var="plastic_s" value="成形"/>
				        href="controller?command=BoardList&board_id=${plastic_s}" 
						target="_parent">成形</a></li>
					<li class="twoline"><a
						<c:set var="physicalscience" value="物理学"/>
				        href="controller?command=BoardList&board_id=${physicalscience}" 
						target="_parent">物理学</a></li>
					<li class="twoline"><a 
						<c:set var="nursing" value="看護学"/>
				        href="controller?command=BoardList&board_id=${nursing}" 
						target="_parent">看護学 </a></li>
					<li class="twoline"><a
						<c:set var="depression" value="鬱"/>
				        href="controller?command=BoardList&board_id=${depression}" 
						target="_parent">鬱</a></li>
					<li class="twoline"><a
						<c:set var="medicalscience" value="医学"/>
				        href="controller?command=BoardList&board_id=${medicalscience}" 
						target="_parent">医学 </a></li>
					<li class="twoline"><a
						<c:set var="literature" value="文学"/>
				        href="controller?command=BoardList&board_id=${literature}" 
						target="_parent">文学</a></li>
					<li class="twoline"><a
						<c:set var="stock_new2" value="株式"/>
				        href="controller?command=BoardList&board_id=${stock_new2}" 
						target="_parent">株式 </a></li>
					<li class="twoline"><a 
						<c:set var="alopecia" value="禿"/>
				        href="controller?command=BoardList&board_id=${alopecia}" 
						target="_parent">禿</a></li>
					<li class="twoline"><a
						<c:set var="immovables" value="不動産"/>
				        href="controller?command=BoardList&board_id=${immovables}" 
						target="_parent">不動産 </a></li>
					<li class="twoline"><a 
						<c:set var="bitcoins" value="ビットコイン"/>
				        href="controller?command=BoardList&board_id=${bitcoins}" 
						target="_parent">ビットコイン</a></li>
				</ul>
			</div>
			<h4 class="cate_tit">
				教育<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li><a 
						<c:set var="admission" value="編入"/>
				        href="controller?command=BoardList&board_id=${admission}" 
						target="_parent">編入</a></li>
					<li><a 
						<c:set var="lsa" value="語学留学"/>
				        href="controller?command=BoardList&board_id=${lsa}" 
						target="_parent">語学留学</a></li>
					<li><a 
						<c:set var="exam_gosi" value="試験"/>
				        href="controller?command=BoardList&board_id=${exam_gosi}" 
						target="_parent">試験</a></li>
					<li class="twoline"><a 
						<c:set var="faexam" value="外務"/>
				        href="controller?command=BoardList&board_id=${faexam}" 
						target="_parent">外務 </a></li>
					<li class="twoline"><a 
						<c:set var="jcexam" value="司法"/>
				        href="controller?command=BoardList&board_id=${jcexam}" 
						target="_parent">司法</a></li>
					<li class="twoline"><a 
						<c:set var="adexam" value="行政"/>
				        href="controller?command=BoardList&board_id=${adexam}" 
						target="_parent">行政 </a></li>
					<li class="twoline"><a
						<c:set var="government" value="公務員"/>
				        href="controller?command=BoardList&board_id=${government}" 
						target="_parent">公務員</a></li>
					<li class="twoline"><a 
						<c:set var="coq" value="資格証"/>
				        href="controller?command=BoardList&board_id=${coq}" 
						target="_parent">資格証 </a></li>
					<li class="twoline"><a 
						<c:set var="toeic" value="TOEIC"/>
				        href="controller?command=BoardList&board_id=${toeic}" 
						target="_parent"> TOEIC </a></li>
					<li class="twoline"><a 
						<c:set var="ec" value="英語会話"/>
				        href="controller?command=BoardList&board_id=${ec}" 
						target="_parent">英語会話</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="dc_pain3" style=""-->
		<div class="section_cate dc_pain3">

			<!--div class="section_dc_pain3"-->

			<h4 class="cate_tit">
				交通・運送<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li class="twoline"><a
						<c:set var="car_new1" value="自動車"/>
				        href="controller?command=BoardList&board_id=${car_new1}" 
						target="_parent">自動車</a></li>
					<li class="twoline"><a
						<c:set var="train" value="鉄道"/>
				        href="controller?command=BoardList&board_id=${train}" 
						target="_parent"> 鉄道</a></li>
					<li class="twoline"><a 
						<c:set var="bicycle" value="自転車"/>
				        href="controller?command=BoardList&board_id=${bicycle}" 
						target="_parent"> 自転車 </a></li>
					<li class="twoline"><a 
						<c:set var="aircraft" value="航空機"/>
				        href="controller?command=BoardList&board_id=${aircraft}" 
						target="_parent">航空機</a></li>
					<li class="twoline"><a 
						<c:set var="bike" value="バイク"/>
				        href="controller?command=BoardList&board_id=${bike}" 
						target="_parent"> バイク</a></li>
					<li class="twoline"><a 
						<c:set var="ship" value="船"/>
				        href="controller?command=BoardList&board_id=${ship}" 
						target="_parent"> 船</a></li>
				</ul>

			</div>

			<h4 class="cate_tit" style="margin-top: 5px;">
				ネット番組<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li><a 
						<c:set var="youtube" value="스마트폰"/>
				        href="controller?command=BoardList&board_id=${youtube}" 
						target="_parent">ユーチューブ</a></li>
					<li><a 
						<c:set var="twitch" value="스마트폰"/>
				        href="controller?command=BoardList&board_id=${twitch}" 
						target="_parent">ツイッチ</a></li>
				</ul>
			</div>
			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="dc_pain5" style=""-->
		<div class="section_cate dc_pain5">

			<!--div class="section_dc_pain5"-->

			<h4 class="cate_tit">
				ミリタリー<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li class="twoline"><a 
						<c:set var="arm" value="機甲"/>
				        href="controller?command=BoardList&board_id=${arm}" 
						target="_parent"> 機甲 </a></li>
					<li class="twoline"><a 
						<c:set var="knife" value="ナイフ"/>
				        href="controller?command=BoardList&board_id=${knife}" 
						target="_parent">ナイフ</a></li>
					<li class="twoline"><a 
						<c:set var="gun" value="銃"/>
				        href="controller?command=BoardList&board_id=${gun}" 
						target="_parent">銃</a></li>
					<li><a 
						<c:set var="army" value="陸軍"/>
				        href="controller?command=BoardList&board_id=${army}" 
						target="_parent">陸軍</a></li>
					<li class="twoline"><a
						<c:set var="navy" value="海軍"/>
				        href="controller?command=BoardList&board_id=${navy}" 
						target="_parent">海軍 </a></li>
					<li class="twoline"><a 
						<c:set var="airforce" value="空軍"/>
				        href="controller?command=BoardList&board_id=${airforce}" 
						target="_parent">空軍</a></li>
				</ul>
	
			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="dc_pain6" style=""-->
		<div class="section_cate dc_pain6">

			<!--div class="section_dc_pain6"-->

			<h4 class="cate_tit">
				仕事<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 68px;">
					<li><a 
						<c:set var="employment" value="就職"/>
				        href="controller?command=BoardList&board_id=${employment}"
						target="_parent"> 就職</a></li>
					<li><a 
						<c:set var="arbeit" value="バイト"/>
				        href="controller?command=BoardList&board_id=${arbeit}"
						target="_parent"> バイト</a></li>
				</ul>

			</div>
			<h4 class="cate_tit">
				生活<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li class="twoline"><a
						<c:set var="loveconsultation" value="恋愛相談"/>
				        href="controller?command=BoardList&board_id=${loveconsultation}" 
						target="_parent">恋愛相談</a></li>
					<li class="twoline"><a 
						<c:set var="agony" value="悩み"/>
				        href="controller?command=BoardList&board_id=${agony}" 
						target="_parent">悩み</a></li>
					<li class="twoline"><a 
						<c:set var="sc" value="貧乏"/>
				        href="controller?command=BoardList&board_id=${sc}" 
						target="_parent">貧乏</a></li>
					<li class="twoline"><a 
						<c:set var="gacha" value="ガチャ"/>
				        href="controller?command=BoardList&board_id=${gacha}" 
						target="_parent">ガチャ </a></li>
					<li class="twoline"><a 
						<c:set var="pride" value="自慢"/>
				        href="controller?command=BoardList&board_id=${pride}" 
						target="_parent">自慢 </a></li>
					<li class="twoline"><a 
						<c:set var="diet" value="ダイエット"/>
				        href="controller?command=BoardList&board_id=${diet}" 
						target="_parent">ダイエット</a></li>
					<li class="twoline"><a
						<c:set var="frustration" value="挫折"/>
				        href="controller?command=BoardList&board_id=${frustration}"
						target="_parent">挫折 </a></li>
					<li class="twoline"><a 
						<c:set var="loan" value="貸出"/>
				        href="controller?command=BoardList&board_id=${loan}"
						target="_parent">貸出</a></li>
					<li><a 
						<c:set var="mystery" value="ミステリー"/>
				        href="controller?command=BoardList&board_id=${mystery}"
						target="_parent">ミステリー</a></li>
					<li><a 
						<c:set var="outsiders" value="ひきこもり"/>
				        href="controller?command=BoardList&board_id=${outsiders}"
						target="_parent">ひきこもり</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>


	</div>
	<!--zz-->
	<div class="cate_box">
		<!--td class="shopping" style=""-->
		<div class="section_cate shopping">

			<!--div class="section_shopping"-->

			<h4 class="cate_tit">
				買い物<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 500px;">
					<li><a style="cursor: default;" href="javascript:;"
						target="_parent">買い物</a></li>
					<li class="noimg"><a
						<c:set var="department_store" value="デパート・マート"/>
				        href="controller?command=BoardList&board_id=${department_store}"
						target="_parent">- デパート・マート</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="person1" style=""-->
		<div class="section_cate person1">

			<!--div class="section_person1"-->

			<h4 class="cate_tit">
				人物・職業<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 500px;">
					<li><a 
						<c:set var="radio_actor" value="声優"/>
				        href="controller?command=BoardList&board_id=${radio_actor}"
						target="_parent">声優</a></li>
					<li class="noimg"><a
						<c:set var="japan_voice" value="日本声優"/>
				        href="controller?command=BoardList&board_id=${japan_voice}"
						target="_parent">日本声優</a></li>
					<li class="noimg"><a
						<c:set var="civilsavant" value="公務員"/>
				        href="controller?command=BoardList&board_id=${civilsavant}"
						target="_parent">公務員</a></li>
					<li class="noimg"><a
						<c:set var="hurita" value="フリーター"/>
				        href="controller?command=BoardList&board_id=${hurita}"
						target="_parent">フリーター</a></li>
					<li class="noimg"><a
						<c:set var="designer" value="デザイナー"/>
				        href="controller?command=BoardList&board_id=${designer}"
						target="_parent">デザイナー</a></li>
					<li class="noimg"><a
						<c:set var="delivery" value="配達"/>
				        href="controller?command=BoardList&board_id=${delivery}"
						target="_parent">配達</a></li>
					<li class="noimg"><a
						<c:set var="doctor" value="日本声優"/>
				        href="controller?command=BoardList&board_id=${doctor}"
						target="_parent">医者</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="game1" style=""-->
		<div class="section_cate game1">

			<!--div class="section_game1"-->

			<h4 class="cate_tit">
				ゲーム1<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 500px;">
					<li><a 
						<c:set var="game1_new" value="ゲーム"/>
				        href="controller?command=BoardList&board_id=${game1_new}"
						target="_parent">ゲーム</a></li>
					<li><a 
						<c:set var="lovegame" value="美少女恋愛"/>
				        href="controller?command=BoardList&board_id=${lovegame}"
						target="_parent">美少女恋愛</a></li>
					<li><a 
						<c:set var="game_classic1" value="古典ゲーム"/>
				        href="controller?command=BoardList&board_id=${game_classic1}"
						target="_parent">古典ゲーム</a></li>
					<li><a 
						<c:set var="boardgame" value="ボードゲーム"/>
				        href="controller?command=BoardList&board_id=${boardgame}"
						target="_parent">ボードゲーム</a></li>
					<li><a 
						<c:set var="fps" value="FPSゲーム"/>
				        href="controller?command=BoardList&board_id=${fps}"
						target="_parent"> FPSゲーム</a></li>
					<li class="noimg"><a
						<c:set var="battlegrounds" value="バトルグラウンド"/>
				        href="controller?command=BoardList&board_id=${battlegrounds}"
						target="_parent">- バトルグラウンド</a></li>
					<li class="noimg"><a 
						<c:set var="overwatch" value="オーバーウォッチ"/>
				        href="controller?command=BoardList&board_id=${overwatch}"
						target="_parent">- オーバーウォッチ</a></li>
					<li class="noimg"><a
						<c:set var="battlefield3" value="バトルフィールド"/>
				        href="controller?command=BoardList&board_id=${battlefield3}"
						target="_parent">- バトルフィールド</a></li>
					<li><a 
						<c:set var="rhythmgame" value="リズムゲーム"/>
				        href="controller?command=BoardList&board_id=${rhythmgame}"
						target="_parent"> リズムゲーム</a></li>
					<li><a 
						<c:set var="mobilegame" value="モバイルゲーム"/>
				        href="controller?command=BoardList&board_id=${mobilegame}"
						target="_parent"> モバイルゲーム</a></li>
					<li class="noimg"><a
						<c:set var="blackdesertmobile" value="アズレン"/>
				        href="controller?command=BoardList&board_id=${blackdesertmobile}"
						target="_parent">- アズレン</a></li>
					<li class="noimg"><a
						<c:set var="blackdesertmobile" value="少女前線"/>
				        href="controller?command=BoardList&board_id=${blackdesertmobile}"
						target="_parent">- 少女前線</a></li>
					<li class="noimg"><a 
						<c:set var="pokemongo" value="ポケモンGO"/>
				        href="controller?command=BoardList&board_id=${pokemongo}"
						target="_parent">- ポケモンGO</a></li>
					<li class="noimg"><a 
						<c:set var="whitecat" value="白猫プロジェクト"/>
				        href="controller?command=BoardList&board_id=${whitecat}"
						target="_parent">- 白猫プロジェクト</a></li>
					<li><a 
						<c:set var="touhou" value="東方プロジェクト"/>
				        href="controller?command=BoardList&board_id=${touhou}"
						target="_parent"> 東方プロジェクト</a></li>
					<li><a 
						<c:set var="fight_game" value="激闘ゲーム"/>
				        href="controller?command=BoardList&board_id=${fight_game}"
						target="_parent"> 激闘ゲーム</a></li>
					<li class="noimg"><a
						<c:set var="fightgametekken" value="鉄拳"/>
				        href="controller?command=BoardList&board_id=${fightgametekken}"
						target="_parent">- 鉄拳</a></li>
					<li><a 
						<c:set var="lovelive" value="ラブライブ"/>
				        href="controller?command=BoardList&board_id=${lovelive}"
						target="_parent"> ラブライブ</a></li>
					<li><a 
						<c:set var="idolmaster" value="アイドルマスター"/>
				        href="controller?command=BoardList&board_id=${idolmaster}"
						target="_parent"> アイドルマスター</a></li>
					<li><a 
						<c:set var="kancolle" value="艦これ"/>
				        href="controller?command=BoardList&board_id=${kancolle}"
						target="_parent"> 艦これ</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="game2" style=""-->
		<div class="section_cate game2">

			<!--div class="section_game2"-->

			<h4 class="cate_tit">
				ゲーム２<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 500px;">
					<li><a 
						<c:set var="online" value="オンライン"/>
				        href="controller?command=BoardList&board_id=${online}"
						target="_parent"> オンライン</a></li>
					<li class=""><a 
						<c:set var="wow_new3" value="WOW"/>
				        href="controller?command=BoardList&board_id=${wow_new3}"
						target="_parent"> WOW </a></li>
					<li class=""><a
						<c:set var="game_mabinogi1" value="マビノギ"/>
				        href="controller?command=BoardList&board_id=${game_mabinogi1}"
						target="_parent">マビノギ</a></li>
					<li><a 
						<c:set var="elsword" value="エールソード"/>
				        href="controller?command=BoardList&board_id=${elsword}"
						target="_parent"> エールソード</a></li>
					<li><a 
						<c:set var="d_fighter_new1" value="アラド戦記"/>
				        href="controller?command=BoardList&board_id=${d_fighter_new1}"
						target="_parent"> アラド戦記</a></li>
					<li><a 
						<c:set var="mabi_heroes" value="マビノギ英雄伝"/>
				        href="controller?command=BoardList&board_id=${mabi_heroes}"
						target="_parent"> マビノギ英雄伝</a></li>
					<li><a 
						<c:set var="tera" value="テーラー"/>
				        href="controller?command=BoardList&board_id=${tera}"
						target="_parent"> テーラー</a></li>
					<li><a 
						<c:set var="leagueoflegends2" value="リーグオブレジェンド"/>
				        href="controller?command=BoardList&board_id=${leagueoflegends2}"
						target="_parent"> リーグオブレジェンド</a></li>
					<li><a class="colortxt"
						<c:set var="starcraft_new" value="スタークラフト"/>
				        href="controller?command=BoardList&board_id=${starcraft_new}"
						target="_parent"> スタークラフト</a></li>
					<li><a 
						<c:set var="starcraft2_new" value="スタークラフト２"/>
				        href="controller?command=BoardList&board_id=${starcraft2_new}"
						target="_parent"> スタークラフト２</a></li>
				</ul>
				<!--p class='list_line' style="margin:10px 0px 10px 0px;border-top:1px dashed #aaa;">gg</p-->

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="game3" style=""-->
		<div class="section_cate game3">

			<!--div class="section_game3"-->

			<h4 class="cate_tit">
				ゲーム３<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 500px;">
					<li><a 
						<c:set var="bd" value="黒い砂漠"/>
				        href="controller?command=BoardList&board_id=${bd}"
						target="_parent"> 黒い砂漠</a></li>
					<li><a 
						<c:set var="closers" value="クローザース"/>
				        href="controller?command=BoardList&board_id=${closers}"
						target="_parent"> クローザース</a></li>
					<li><a 
						<c:set var="ff14" value="ファイナルファンタジー14"/>
				        href="controller?command=BoardList&board_id=${ff14}"
						target="_parent"> ファイナルファンタジー14</a></li>
					<li><a 
						<c:set var="tos" value="ツリーオブセイヴァー"/>
				        href="controller?command=BoardList&board_id=${tos}"
						target="_parent"> ツリーオブセイヴァー</a></li>
					<li><a 
						<c:set var="soulworker" value="ソウルワーカー"/>
				        href="controller?command=BoardList&board_id=${soulworker}"
						target="_parent"> ソウルワーカー</a></li>
						<li><a 
						<c:set var="playstation" value="プレイステーション"/>
				        href="controller?command=BoardList&board_id=${playstation}"
						target="_parent">プレイステーション</a></li>
					<li><a 
						<c:set var="vita" value="PSP"/>
				        href="controller?command=BoardList&board_id=${vita}"
						target="_parent"> PSP</a></li>
					<li><a 
						<c:set var="nintendo" value="任天堂"/>
				        href="controller?command=BoardList&board_id=${nintendo}"
						target="_parent"> 任天堂</a></li>
				</ul>
				<!--p class='list_line' style="margin:10px 0px 10px 0px;border-top:1px dashed #aaa;">gg</p-->

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="broadcasting1" style=""-->
		<div class="section_cate broadcasting1">

			<!--div class="section_broadcasting1"-->

			<h4 class="cate_tit">
				放送<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 500px;">
					<li><a 
						<c:set var="kbs_drama" value="NHK"/>
				        href="controller?command=BoardList&board_id=${kbs_drama}"
						target="_parent"> NHK</a></li>
					<li><a 
						<c:set var="mbc_drama" value="日本テレビ"/>
				        href="controller?command=BoardList&board_id=${mbc_drama}"
						target="_parent"> 日本テレビ</a></li>
					<li class="noimg"><a class="colortxt"
						<c:set var="springnight" value="テレビ朝日"/>
				        href="controller?command=BoardList&board_id=${springnight}"
						target="_parent"> テレビ朝日</a></li>
					<li><a 
						<c:set var="sbs_drama" value="東京放送"/>
				        href="controller?command=BoardList&board_id=${sbs_drama}"
						target="_parent"> 東京放送</a></li>
					<li><a 
						<c:set var="sbs_drama" value="フジテレビ"/>
				        href="controller?command=BoardList&board_id=${sbs_drama}"
						target="_parent"> フジテレビ</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="broadcasting2" style=""-->
		<div class="section_cate broadcasting2">

			<!--div class="section_broadcasting2"-->

			<h4 class="cate_tit">
				放送2<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 500px;">
					<li><a 
						<c:set var="etc_program2" value="放送・ほか"/>
				        href="controller?command=BoardList&board_id=${etc_program2}"
						target="_parent"> 放送・ほか</a></li>
					<li><a 
						<c:set var="comedy_new1" value="コメディ"/>
				        href="controller?command=BoardList&board_id=${comedy_new1}"
						target="_parent"> コメディ</a></li>
					<li><a 
						<c:set var="entertain" value="芸能"/>
				        href="controller?command=BoardList&board_id=${entertain}"
						target="_parent"> 芸能</a></li>
				</ul>
			</div>
			<h4 class="cate_tit">
				海外放送<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="">
					<li><a 
						<c:set var="america_drama" value="アメリカ・ドラマ"/>
				        href="controller?command=BoardList&board_id=${america_drama}"
						target="_parent"> アメリカ・ドラマ</a></li>
					<li><a 
						<c:set var="japan_drama" value="韓ドラ"/>
				        href="controller?command=BoardList&board_id=${japan_drama}"
						target="_parent"> 韓ドラ</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>


	</div>
	<!--zz-->
	<div class="cate_box">
		<!--td class="music" style=""-->
		<div class="section_cate music">

			<!--div class="section_music"-->

			<h4 class="cate_tit">
				音楽<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 400px;">
					<li class=""><a 
						<c:set var="rock" value="ロック"/>
				        href="controller?command=BoardList&board_id=${rock}"
						target="_parent"> ロック </a></li>
					<li class=""><a 
						<c:set var="hiphop" value="ヒップホップ"/>
				        href="controller?command=BoardList&board_id=${hiphop}"
						target="_parent">ヒップホップ</a></li>
					<li><a 
						<c:set var="instruments" value="楽器"/>
				        href="controller?command=BoardList&board_id=${instruments}"
						target="_parent"> 楽器</a></li>
					<li><a 
						<c:set var="classic" value="クラシック"/>
				        href="controller?command=BoardList&board_id=${classic}"
						target="_parent"> クラシック</a></li>
					<li><a 
						<c:set var="compose" value="作曲"/>
				        href="controller?command=BoardList&board_id=${compose}"
						target="_parent"> 作曲</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>
		
		<div class="section_cate music">

			<!--div class="section_music"-->

			<h4 class="cate_tit">
				音響機械<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 400px;">
					<li class=""><a 
						<c:set var="earphone" value="イヤホン"/>
				        href="controller?command=BoardList&board_id=${earphone}"
						target="_parent"> イヤホン </a></li>
					<li class=""><a 
						<c:set var="headphone" value="ヘットフォン"/>
				        href="controller?command=BoardList&board_id=${headphone}"
						target="_parent">ヘットフォン</a></li>
					<li><a 
						<c:set var="highres" value="ハイレゾ"/>
				        href="controller?command=BoardList&board_id=${highres}"
						target="_parent">ハイレゾ</a></li>
					<li><a 
						<c:set var="musicplayer" value="音楽プレーヤー"/>
				        href="controller?command=BoardList&board_id=${musicplayer}"
						target="_parent"> 音楽プレーヤー</a></li>
					<li><a 
						<c:set var="amp" value="アンプ"/>
				        href="controller?command=BoardList&board_id=${amp}"
						target="_parent"> アンプ</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>
		



		<!--td class="sports" style=""-->
		<div class="section_cate sports">

			<!--div class="section_sports"-->

			<h4 class="cate_tit">
				スポーツ<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 400px;">
					<li class="twoline"><a 
						<c:set var="baseball" value="野球"/>
				        href="controller?command=BoardList&board_id=${baseball}"
						target="_parent"> 野球</a></li>
					<li class="twoline"><a 
						<c:set var="extra" value="ヘルシー"/>
				        href="controller?command=BoardList&board_id=${extra}"
						target="_parent">ヘルシー</a></li>
					<li class="twoline"><a 
						<c:set var="basketball" value="バスケット"/>
				        href="controller?command=BoardList&board_id=${basketball}"
						target="_parent"> バスケット</a></li>
					<li class="twoline"><a 
						<c:set var="volleyball" value="排球"/>
				        href="controller?command=BoardList&board_id=${volleyball}"
						target="_parent"> 排球</a></li>
					<li class="twoline"><a 
						<c:set var="boxing" value="ボクシング"/>
				        href="controller?command=BoardList&board_id=${boxing}"
						target="_parent"> ボクシング </a></li>
					<li class="twoline"><a 
						<c:set var="tennis" value="テニス"/>
				        href="controller?command=BoardList&board_id=${tennis}"
						target="_parent">テニス</a></li>
					<li class="twoline"><a 
						<c:set var="football" value="サッカー"/>
				        href="controller?command=BoardList&board_id=${football}"
						target="_parent"> サッカー</a></li>
				</ul>
			</div>
			


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="person_entertainment1" style=""-->
		<div class="section_cate person_entertainment1">

			<!--div class="section_person_entertainment1"-->

			<h4 class="cate_tit">
				人物・芸人<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 400px;">
					<li><a 
						<c:set var="entertainment" value="芸人"/>
				        href="controller?command=BoardList&board_id=${entertainment}"
						target="_parent"> 芸人</a></li>
					<li><a 
						<c:set var="japan_entertainment" value="日本芸人"/>
				        href="controller?command=BoardList&board_id=${japan_entertainment}"
						target="_parent">日本芸人</a></li>
					<li><a 
						<c:set var="w_entertainer" value="女子芸能人"/>
				        href="controller?command=BoardList&board_id=${w_entertainer}"
						target="_parent"> 女子芸能人</a></li>
					<li><a 
						<c:set var="m_entertainer" value="男子芸能人"/>
				        href="controller?command=BoardList&board_id=${m_entertainer}"
						target="_parent"> 男子芸能人</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="person_entertainment2" style=""-->
		<div class="section_cate person_entertainment2">

			<!--div class="section_person_entertainment2"-->

			<h4 class="cate_tit">
				人物・歌手<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 400px;">
					<li><a 
						<c:set var="akb" value="AKB48"/>
				        href="controller?command=BoardList&board_id=${akb}"
						target="_parent"> AKB48</a></li>
					<li><a 
						<c:set var="keyakizaka" value="欅坂46"/>
				        href="controller?command=BoardList&board_id=${keyakizaka}"
						target="_parent"> 欅坂46</a></li>
					<li><a 
						<c:set var="nogizaka" value="乃木坂46"/>
				        href="controller?command=BoardList&board_id=${nogizaka}"
						target="_parent"> 乃木坂46</a></li>
					<li><a 
						<c:set var="girlsG" value="少女時代"/>
				        href="controller?command=BoardList&board_id=${girlsG}"
						target="_parent"> 少女時代</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="person_entertainment4" style=""-->
		<div class="section_cate person_entertainment4">

			<!--div class="section_person_entertainment4"-->

			<h4 class="cate_tit">
				大学<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 400px;">
					<li><a 
						<c:set var="two_year_university" value="短期大学"/>
				        href="controller?command=BoardList&board_id=${two_year_university}"
						target="_parent"> 短期大学</a></li>
					<li><a 
						<c:set var="four_year_university" value="４年大学"/>
				        href="controller?command=BoardList&board_id=${four_year_university}"
						target="_parent"> ４年大学</a></li>
					<li><a 
						<c:set var="univ_edu" value="教育大学"/>
				        href="controller?command=BoardList&board_id=${univ_edu}"
						target="_parent"> 教育大学</a></li>
					<li><a 
						<c:set var="foreign_university" value="外国大学"/>
				        href="controller?command=BoardList&board_id=${foreign_university}"
						target="_parent"> 外国大学</a></li>
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>



		<!--td class="person_entertainment5" style=""-->
		<div class="section_cate person_entertainment5">

			<!--div class="section_person_entertainment5"-->

			<h4 class="cate_tit">
				臨時<span class="list_num"></span>
			</h4>
			<div class="cate">
				<ul style="height: 400px;">
				</ul>

			</div>


			<!--/div-->
			<!--category end-->


			<!--/td-->
		</div>


	</div>
	<!--zz-->



	</div>
	<!--zz-->
	<!--/tr-->





<%@ include file="popup.jsp"%>
<%@ include file="footer.jsp"%>