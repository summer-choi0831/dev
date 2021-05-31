<template xmlns="http://www.w3.org/1999/html">
  <div class="container-fluid">
    <b-img center src='http://3.37.98.94/static/img/title.png'></b-img>
    <div v-if="mode === 'intro'" class="row" >
      <div >
        <p class="mt-5 flex-center">
          <label class="mr-5" for="name">
            <font style="font-size:40px">이름을 입력해주세요. </font>
          </label>
        </p>
        <div class="flex-center" >
          <input class="form-control-lg" type="text" v-model="name"/>
        </div>
        <p class="mt-5 flex-center">
          <button
            type="button"
            class="btn btn-success btn-lg"
            @click="go('start')"
          >
            미궁 입장
          </button>
        </p>
      </div>
    </div>

    <div v-if="mode === 'start'">
      <p class="text-center">
        <font size="6px">
          장재영 X 최선정 <br><br>
          서로 다른 과거를 살아온 두 사람이<br>
          이제는 같은 미래를 준비하고자 합니다.<br><br>

          평생을 약속하는 뜻깊은 자리,<br>
          <b>{{ this.name }}</b>님께서 함께해 주기를 바라는 마음에<br>
          이번 초대장을 만들게 되었습니다.<br><br>
          <b-img center src='http://3.37.98.94/static/img/card_01.png'></b-img>

          <br>초대장 내에 예식에 대한 정보를 담았으니<br>
          찾아오시는 데 참고하기를 바랍니다.<br><br>

          그럼, 예식이 시작되는 날, 식장에서<br>
          <b>{{ this.name }}</b>님을 뵐 수 있기를<br>
          진심으로 고대하고 있겠습니다.<br><br>

          - 재영ㆍ선정 올림<br>
        </font>
      </p>

      <span class="mt-5 flex-center">
        <button
          type="button"
          class=" btn btn-success btn-lg"
          @click="go('question')"
        >
          미궁 시작
        </button>
      </span>
      <span class="mt-5 flex-center">
      </span>
    </div>

    <div v-if="mode === 'question'">
      <div class="mt-5 progress">
        <div class="progress-bar bg-danger" role="progressbar" v-bind:style="{width : this.progress + '%'}" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
      </div>
      <span class="mt-5 flex-center">
        <b-img center :src="question[question_num].img" rounded></b-img>
        <b-img v-bind="{  width: 413, height: 294 }" center :src="question[question_num].card" rounded></b-img>
      </span>
      <span class="mt-5 flex-center">
        <input style="font-size:40px" type="text" id="name" v-model="cur_answer"/>
        <button
          type="button"
          class=" btn btn-success btn-lg"
          @click="go_question(question_num + 1)"
        >
          정답 제출
        </button>
      </span>
      <span class="mt-5 flex-center">
      </span>
    </div>

    <div v-if="mode === 'end'">
      <transition name="fade">
        <b-img center src='http://3.37.98.94/static/img/card_07.png'></b-img>
      </transition>
      <span class="mt-5 flex-center">
        <p class="text-center">
          <font size="6px">
            결혼식장에 가기 위해<br>
            험난한 미궁을 헤쳐온<br>
            당신의 노고를 치하합니다.<br><br>

            <b>{{ this.name }}</b>님이야말로<br>
            식장에 참석할 자격이 있는<br>
            진정한 하객의 혼을 지닌 적격자입니다.<br><br>

            당신이 지금까지 헤쳐온 험난한 길은<br>
            결혼식에 참석할 스스로의 자격을 증명하였습니다.<br><br>

            자, 이제 아래 버튼을 눌러 청첩장을 확인하고<br>
            결혼식에 참가해 보세요!<br><br>

            식장에 입장하여 두 사람의 결혼을 축하하고,<br>
            참석한 다른 하객들과 자웅을 겨루십시오!<br><br>
            </font>
          </p>
      </span>
      <span class="flex-center">
        <button
          onclick="window.open('https://bojagicard.com/g/home.php?ecard=zaer0')"
          type="button"
          class="btn btn-outline-info btn-lg"
        >모바일 청첩장 보러가기</button>
      </span>
      <span class="mt-5 flex-center">
      </span>
    </div>
  </div>
</template>

<script>
export default {
  name: "WeddingCard",
  data() {
    return {
      name: undefined,
      mode: "intro", // intro, start, question, end
      question_num: 0,
      cur_answer: "",
      progress: 0,
      question: [
        {img: "http://3.37.98.94/static/img/01.png", hint: "첫 인연이 시작된날은? 20ㅇㅇ.ㅇ.ㅇㅇ(숫자만)", answer: "16416", card: "http://3.37.98.94/static/img/card_02.png"},
        {img: "http://3.37.98.94/static/img/02.png", hint: "결혼식 날짜. 6월 ㅇㅇ일(숫자만)", answer: "13", card: "http://3.37.98.94/static/img/card_03.png"},
        {img: "http://3.37.98.94/static/img/03.png", hint: "결혼식 시간. ㅇㅇ:ㅇㅇ(숫자만)", answer: "1330", card: "http://3.37.98.94/static/img/card_04.png"},
        {img: "http://3.37.98.94/static/img/04.png", hint: "지하철역(ㅇㅇㅇ역)", answer: "보라매", card:  "http://3.37.98.94/static/img/card_05.png"},
        {img: "http://3.37.98.94/static/img/05.png", hint: "결혼식 장소(대문자)", answer: "NOBLESSE", card:  "http://3.37.98.94/static/img/card_06.png"}
      ]
    };
  },
  methods: {
    go(mode) {
      console.log("go mode ", mode);
      this.mode = mode;
    },
    go_question(num) {
      console.log("this.question.length", this.question.length)
      console.log("num", num)
      if (num < this.question.length) {
        if (this.cur_answer === this.question[this.question_num].answer) {
          this.progress = this.progress + 20;
          this.question_num = num;
          this.cur_answer = "";
        } else {
          alert("오답입니다. \n" + this.question[this.question_num].hint)
        }

      } else {
        if (this.cur_answer === this.question[this.question_num].answer) {
          this.go("end");
        } else {
          alert("오답입니다. \n" + this.question[this.question_num].hint)
        }
      }
    }
  }
};
</script>
<style>
.fade-enter {
  transition: opacity .5s;
}

body {
  background-color: #ffffff;
}

.container {
  text-align: center;
}

.input {
  font-size: 20px
}

.btn {
  font-size: 20px
}

.flex-center {
  display: flex;
  justify-content: center;
}
</style>
