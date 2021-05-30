<template xmlns="http://www.w3.org/1999/html" >
  <div class="container-fluid mt-5" >
    <h1><p class="text-center">미궁 ~ 숨겨진 결혼식장을 찾아라 ~</p></h1>

    <div v-if="mode === 'intro'" class="row">
      <div class="col-md-4"></div>
      <div class="col-md-4">
        <p class="mt-5 flex-center">
          <label class="mr-5" for="name">이름 </label>
          <input type="text" id="name" v-model="name" />
        </p>
        <p class="mt-5 flex-center">
          <button
            type="button"
            class="btn btn-success btn-lg"
            @click="go('start')"
          >
            입장
          </button>
        </p>
      </div>
      <div class="col-md-4"></div>
    </div>

    <div v-if="mode === 'start'">
      <p class="mt-5 text-center">
        안녕? {{ this.name }} 아. 문제를 풀어야 결혼식장을 갈수 있어, 자
        시작해보자
      </p>

      <span class="mt-5 flex-center">
        <button
          type="button"
          class=" btn btn-success btn-lg"
          @click="go('question')"
        >
          미궁시작~
        </button>
      </span>
    </div>

    <div v-if="mode === 'question'">
      <div class="mt-5 progress">
        <div class="progress-bar bg-danger" role="progressbar" v-bind:style="{width : this.progress + '%'}" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
      </div>
      <span class="mt-5 flex-center">
        <b-img center :src="question[question_num].img" rounded ></b-img>
      </span>
      <span class="mt-5 flex-center">
        <h6>hint </h6><font color="ffffff">{{question[question_num].hint}}</font>
      </span>
      <span class="flex-center">
        <input type="text" id="name" v-model="cur_answer" />
        <button
          type="button"
          class=" btn btn-success btn-lg"
          @click="go_question(question_num + 1)"
        >
          정답 제출
        </button>
      </span>
    </div>

    <div v-if="mode === 'end'">
      <span class="mt-5 flex-center">
        <p>
          여기까지 와줘서 고마워 {{ this.name }} 아~~~ ^^ 결혼 축하해 줘서 기뻐!
        </p>
      </span>
      <span class="mt-5 flex-center">
        <a href="https://bojagicard.com/g/home.php?ecard=zaer0" >청첩장 받으러가기</a>
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
      mode: "question", // intro, start, question, end
      question_num: 0,
      cur_answer: "",
      progress: 0,
      question: [

        { img: "http://13.124.84.76/static/img/01.png", hint: "첫 인연이 시작된날은? 20ㅇㅇ.ㅇ.ㅇㅇ(숫자만)", answer: "" },
        { img: "http://13.124.84.76/static/img/02.png", hint: "결혼식 날짜. 6월 ㅇㅇ일(숫자만)", answer: "" },
        { img: "http://13.124.84.76/static/img/03.png", hint: "결혼식 시간. ㅇㅇ:ㅇㅇ(숫자만))", answer: "" },
        { img: "http://13.124.84.76/static/img/04.png", hint: "지하철역(ㅇㅇㅇ역)", answer: "" },
        { img: "http://13.124.84.76/static/img/05.png", hint: "결혼식 장소(대문자)", answer: "" }
        // { img: "http://13.124.84.76/static/img/01.png", hint: "첫 인연이 시작된날은? 20ㅇㅇ.ㅇ.ㅇㅇ(숫자만)", answer: "16416" },
        // { img: "http://13.124.84.76/static/img/02.png", hint: "결혼식 날짜. 6월 ㅇㅇ일(숫자만)", answer: "13" },
        // { img: "http://13.124.84.76/static/img/03.png", hint: "결혼식 시간. ㅇㅇ:ㅇㅇ(숫자만))", answer: "1330" },
        // { img: "http://13.124.84.76/static/img/04.png", hint: "지하철역(ㅇㅇㅇ역)", answer: "보라매" },
        // { img: "http://13.124.84.76/static/img/05.png", hint: "결혼식 장소(대문자)", answer: "NOBLESSE" }
      ]
    };
  },
  methods: {
    go(mode) {
      console.log("go mode ", mode);
      this.mode = mode;
    },
    go_question(num) {

      if (num < this.question.length) {
        console.log("go_question", num);

        if(this.cur_answer === this.question[this.question_num].answer){
          // alert("정답입니다!")
          this.progress = this.progress + 20;
          this.question_num = num;
          this.cur_answer = "";
        }else{
          alert("오답입니다. 힌드를 보려면 드래그를 하세요!")
        }

      } else {
        this.go("end");
      }
    }
  }
};
</script>
<style >

body { background-color: #ffffff; }
.container {
  text-align: center;
}

.flex-center {
  display: flex;
  justify-content: center;
}
</style>
