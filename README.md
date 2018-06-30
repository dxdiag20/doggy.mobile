# 개같은 내얼굴

## Doggy?

흔히 '개같다'라고 하면 일단은 부정적인 생각이 떠오를 것입니다. 아마도 우리 생활 속에서 흔히볼 수 있고 친근한 개에 대해 은연 중에 하찮은 존재라고 여기고 있기 때문일 겁니다. '개같은 내얼굴'은 개같은 얼굴을 한 우리, 그리고 개가 똑같은 하나의 생명임을 느끼고 이를 통하여 개에 대해 관심을 가지고 사랑해줬으면 하는 마음에서 출발했습니다. 

## Service Overview

<img src="https://raw.githubusercontent.com/42deSix/Images/master/doggy_storyboard.png" width="100%"/>

120종의 견종 중 사진 속의 사람과 가장 닮은 견종이 무엇인지 찾아주고 해당 견종에 대해 설명해주는 가벼운 모바일 서비스입니다. 결과를 통해 즐거워하신 만큼 해당 견종을 사랑해주시기 바랍니다.

## Technical Overview

[Inception-v3 학습모델](https://github.com/openhack-Doggy/doggy.machine-learning)으로 학습된 120종의 견종을 구분하는 모델을 [Flask 서버](https://github.com/openhack-Doggy/doggy.server) 상에 업로드합니다. 안드로이드 기기에서 촬영된 사진을 서버에 보내어 가장 닮은 견종이 무엇인지를 응답으로 받습니다.

