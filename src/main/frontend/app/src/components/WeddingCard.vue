<template xmlns="http://www.w3.org/1999/html" >
  <div class="container-fluid mt-5" >
        <b-img center src='http://13.124.84.76/static/img/title.png' ></b-img>
    <div v-if="mode === 'intro'" class="row">
      <div>
        <p class="mt-5 flex-center">
          <label class="mr-5" for="name">
            <font size="12px">이름을 입력해주세요. </font>
          </label>
        </p>
        <p class="flex-center">
          <input class="form-control form-control-lg" type="text"  v-model="name" />
        </p>
        <p class="flex-center">
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
      <p class="mt-5 text-center">
        <font size="12px">
        장재영 X 최선정 <br><br>
        서로 다른 과거를 살아온 두 사람이<br>
        이제는 같은 미래를 준비하고자 합니다.<br><br>

        평생을 약속하는 뜻깊은 자리,<br>
        <b>{{ this.name }}</b>님께서 함께해 주기를 바라는 마음에<br>
        이번 초대장을 만들게 되었습니다.<br><br>

        초대장 내에 예식에 대한 정보를 담았으니<br>
        찾아오시는 데 참고하기를 바랍니다.<br><br>

        그럼, 예식이 시작되는 날, 식장에서<br>
        <b>{{ this.name }}</b>님을 뵐 수 있기를<br>
        진심으로 고대하고 있겠습니다.<br><br>

        - 재영ㆍ선정 올림<br><br>
        </font>
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
        <input type="text" id="name" v-model="cur_answer" />
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
      <span class="mt-5 flex-center">
        <p>
          여기까지 와줘서 고마워 {{ this.name }} 아~~~ ^^ 결혼 축하해 줘서 기뻐!
        </p>
      </span>
      <span class="mt-5 flex-center">
        <b-button href="https://bojagicard.com/g/home.php?ecard=zaer0"  variant="outline-info">청첩장 보러가기</b-button>
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

        // { img: "http://13.124.84.76/static/img/01.png", hint: "첫 인연이 시작된날은? 20ㅇㅇ.ㅇ.ㅇㅇ(숫자만)", answer: "" },
        // { img: "http://13.124.84.76/static/img/02.png", hint: "결혼식 날짜. 6월 ㅇㅇ일(숫자만)", answer: "" },
        // { img: "http://13.124.84.76/static/img/03.png", hint: "결혼식 시간. ㅇㅇ:ㅇㅇ(숫자만))", answer: "" },
        // { img: "http://13.124.84.76/static/img/04.png", hint: "지하철역(ㅇㅇㅇ역)", answer: "" },
        // { img: "http://13.124.84.76/static/img/05.png", hint: "결혼식 장소(대문자)", answer: "" }
        { img: "http://13.124.84.76/static/img/01.png", hint: "첫 인연이 시작된날은? 20ㅇㅇ.ㅇ.ㅇㅇ(숫자만)", answer: "16416" },
        { img: "http://13.124.84.76/static/img/02.png", hint: "결혼식 날짜. 6월 ㅇㅇ일(숫자만)", answer: "13" },
        { img: "http://13.124.84.76/static/img/03.png", hint: "결혼식 시간. ㅇㅇ:ㅇㅇ(숫자만))", answer: "1330" },
        { img: "http://13.124.84.76/static/img/04.png", hint: "지하철역(ㅇㅇㅇ역)", answer: "보라매" },
        { img: "http://13.124.84.76/static/img/05.png", hint: "결혼식 장소(대문자)", answer: "NOBLESSE" }
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
          alert("오답입니다. \n" + this.question[this.question_num].hint)
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
