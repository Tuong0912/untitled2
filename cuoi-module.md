# untitled2

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body onload="chuyendong()">
<canvas id="myCanvas" width="500px" height="650px"
        style=" border:5px solid red; left: 400px;position: absolute"></canvas>
<h2 style="position: absolute ; left: 300px; top:5px">Điểm:</h2>
<button type="button" onclick="choi()" style="width: 80px;height: 50px ;position: absolute;top: 100px;left: 300px ">PLAY
</button>
<button type="button" onclick="reset()" style="width: 80px;height: 50px ;position: absolute;top: 160px;left: 300px ">
    RESET
</button>
<h2 id="rs" style="position: absolute ; left: 370px;top:5px"></h2>

<script>

    let canvas = document.getElementById("myCanvas");
    let text = canvas.getContext('2d');
    let grd = text.createLinearGradient(0, 0, 1000, 0);//Setup đổi màu bóng
    grd.addColorStop(0, "red");//Setup đổi màu bóng
    grd.addColorStop(1, "blue");//Setup đổi màu bóng

    let Bong = function (x1, y1, bankinh, vx, vy) {
        this.x1 = x1;
        this.y1 = y1;
        this.bankinh = bankinh;
        this.vx = vx;
        this.vy = vy;
        this.hinhtron = function () {
            text.beginPath();
            text.fillStyle = grd;
            text.arc(this.x1, this.y1, this.bankinh, 0, Math.PI*2);//khởi tạo quả bóng
            text.stroke();
            text.fill();
        };
        this.dichuyen = function (thanhdo) {
            this.x1 += this.vx;//thay đôi tọa độ bóng
            this.y1 += this.vy;//thay đôi tọa độ bóng
            if (this.x1 > canvas.width - this.bankinh || this.x1 < 0)//bóng đập cạnh thì naỷ lại
                this.vx = -this.vx;
            if (this.y1 < 0) this.vy = -this.vy;
            if (this.x1 < thanhdo.x + (thanhdo.dai) && this.y1 < thanhdo.y + thanhdo.rong &&
                this.x1 > thanhdo.x - (thanhdo.dai) && this.y1 > thanhdo.y - thanhdo.rong) {
                this.vy = -vy
            }
        };
        this.toadobandau = function () {
            this.x1 = x1;
            this.y1 = y1;
        }

    };
    let Thanhdo = function (color, x, y, dai, rong, VX) {
        this.VX = VX;
        this.x = x;
        this.y = y;
        this.dai = dai;
        this.rong = rong;
        this.trangthai = "sangphai";
        this.hinh = function () {
            text.fillStyle = color;
            text.fillRect(this.x, this.y, this.dai, this.rong);
            text.stroke();
        };
        this.sangtrai = function () {
            if (this.x <= canvas.width - this.dai)
                this.x += this.VX
        };
        this.sangphai = function () {
            if (this.x >= 0)
                this.x += -this.VX
        };
        this.chuyenthanhdo = function () {
            switch (this.trangthai) {
                case "sangtrai":
                    this.sangtrai();
                    break;
                case "sangphai":
                    this.sangphai();
                    break
            }
        }
    };
    let Gach = function (dai, rong) {
        this.doX = 25;
        this.doY = 25;
        this.khongcach = 15;
        this.daiV = dai;
        this.rongV = rong;
        // this.hang1 = 1;
        // this.cot1 = 1;


        for (i = 0; i < hang1; i++) {

            for (j = 0; j < cot1; j++) {
                mang.push({
                    cx: this.doX + j * (this.daiV + this.khongcach),
                    cy: this.doY + i * (this.rongV + this.khongcach),
                    trangthaigach: false
                })
            }
        }
        this.taogach = function (gach) {

            mang.forEach(function (b) {
                if (!b.trangthaigach) {
                    text.beginPath();
                    text.rect(b.cx, b.cy, gach.daiV, gach.rongV);
                    text.fill();
                    text.fillStyle = "blue";
                    text.closePath()
                }
            });
        };
        this.vatramgach = function (bong, gach) {
            mang.forEach(function (b) {
                if (!b.trangthaigach) {
                    if (bong.x1 >= b.cx && bong.x1 <= b.cx + gach.daiV &&
                        bong.y1 + bong.bankinh >= b.cy && bong.y1 - bong.bankinh <= b.cy + gach.rongV) {
                        bong.vy = -bong.vy;
                        bong.vx = -bong.vy;
                        b.trangthaigach = true;
                        diem += 1;
                        sl = sl-1;
                        console.log('ggg',sl);
                    }
                }
            })

        };

    };
    let hang1 = 10;
    let cot1 = 8;
    let sl = hang1 * cot1;
    let bong = new Bong(250, 280, 10, 1, 1);
    let thanhdo = new Thanhdo("black", 220, 640, 90, 10, 1.5);
    let mang = [];
    let diem = 0;
    let gach = new Gach(42, 10, "blue");
    gach.taogach(gach);
    bong.hinhtron();
    thanhdo.hinh();

    function dichuyenThanhdo(e) {
        switch (e.keyCode) {
            case 37:
                thanhdo.trangthai = "sangphai";
                break;
            case 39:
                thanhdo.trangthai = "sangtrai";
                break;
        }
        console.log(thanhdo.trangthai)
    }

    function chuyendong() {
        window.addEventListener("keydown", dichuyenThanhdo)
    }

    function GameOver() {
        if (bong.y1 > canvas.height - bong.bankinh) {
            clearInterval(start);
            alert("Gà!!!")
        }
    }

    function gamewin() {
        document.getElementById("rs").innerHTML = diem;
        if (diem > 4) {
            clearInterval(start);
            alert("Giỏi!!!")
        }
    }

    let start;

    function GameStart() {
        start = setInterval(function () {
            text.clearRect(0, 0, canvas.width, canvas.height);
            bong.hinhtron();
            bong.dichuyen(thanhdo);
            thanhdo.hinh();
            gach.taogach(gach);
            gach.vatramgach(bong, gach);
            thanhdo.chuyenthanhdo();
            chuyendong();
            GameOver();
            gamewin();
        }, 1);
    }

    function reset() {
        window.location.reload();
    }

    function choi() {
        GameStart();
        console.log('kk',sl);
    }

</script>
</body>
</html>
