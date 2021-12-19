package pl.toboche

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class Day18Test {
    val input = ("[[7,[8,[3,5]]],[[[3,6],9],1]]\n" +
            "[[[[1,7],8],[0,4]],[[[0,9],2],[2,[5,6]]]]\n" +
            "[[[4,[4,4]],[8,[4,4]]],[[5,4],6]]\n" +
            "[[[1,[1,3]],[[9,6],1]],[[4,[5,4]],[[4,4],[0,8]]]]\n" +
            "[[[[6,2],[2,5]],[2,1]],[[1,5],7]]\n" +
            "[[[[5,0],[2,7]],[[2,5],2]],[2,[3,2]]]\n" +
            "[[[6,[6,6]],[0,[2,8]]],[[8,[5,6]],[4,5]]]\n" +
            "[[[6,[3,5]],8],[[2,[7,0]],5]]\n" +
            "[[[[7,8],[3,6]],[1,6]],[[[4,2],1],[[0,7],[5,6]]]]\n" +
            "[8,2]\n" +
            "[[5,5],[[2,[9,1]],8]]\n" +
            "[[[4,8],[[1,8],2]],[9,2]]\n" +
            "[2,[[8,[8,3]],[0,6]]]\n" +
            "[[[6,6],[[6,0],6]],[0,[[3,4],3]]]\n" +
            "[[[[2,9],[5,9]],[2,[4,3]]],[6,0]]\n" +
            "[[[6,2],0],[7,7]]\n" +
            "[[[9,6],5],[2,[[0,1],[5,5]]]]\n" +
            "[[6,[[0,1],[5,1]]],5]\n" +
            "[4,[[[4,2],3],[2,[5,0]]]]\n" +
            "[[[7,9],2],2]\n" +
            "[[[5,[2,1]],1],[[1,1],[8,5]]]\n" +
            "[[[[5,9],0],[[1,9],0]],4]\n" +
            "[[7,[0,5]],[[0,3],[8,2]]]\n" +
            "[[6,[9,[7,7]]],6]\n" +
            "[2,[[1,[1,0]],[4,[6,1]]]]\n" +
            "[[0,6],[[[5,1],6],[[4,7],[8,0]]]]\n" +
            "[[[1,[4,7]],[0,[1,2]]],[[1,1],[[1,2],[1,3]]]]\n" +
            "[[8,[3,0]],[3,[1,[8,1]]]]\n" +
            "[[[7,[4,0]],[[8,7],2]],[[7,[7,3]],7]]\n" +
            "[3,[[1,7],2]]\n" +
            "[8,[[[1,5],0],1]]\n" +
            "[[6,[1,4]],7]\n" +
            "[[[[2,6],2],8],1]\n" +
            "[9,7]\n" +
            "[9,[[[1,1],1],[[3,0],[7,3]]]]\n" +
            "[[[[8,5],7],[[5,1],[6,4]]],[4,[[7,6],[2,7]]]]\n" +
            "[[[[8,7],1],0],[[9,9],[[1,0],8]]]\n" +
            "[[9,[[1,1],7]],[[3,0],4]]\n" +
            "[[[[8,2],4],[9,[7,9]]],[[0,2],[[3,0],5]]]\n" +
            "[[[[3,6],3],[[9,7],[0,6]]],[[[4,9],[1,3]],[2,[7,3]]]]\n" +
            "[[[[3,8],0],[[3,6],5]],[[3,[4,2]],[[6,1],[8,5]]]]\n" +
            "[[2,7],[[0,0],8]]\n" +
            "[[[[0,3],7],[2,0]],3]\n" +
            "[[0,2],[[[3,1],0],[0,0]]]\n" +
            "[[[[6,1],7],[[8,4],[2,4]]],[[1,6],[2,3]]]\n" +
            "[[2,[2,[9,1]]],[4,[[0,4],9]]]\n" +
            "[[[3,[5,6]],7],1]\n" +
            "[[[3,0],[8,[9,3]]],[[[1,1],1],[6,7]]]\n" +
            "[[[6,[4,4]],[[1,9],1]],[[[8,1],[9,8]],[[6,3],1]]]\n" +
            "[[[5,8],[[0,3],[1,7]]],[[[3,2],[4,7]],1]]\n" +
            "[[5,5],[[[8,3],[6,6]],2]]\n" +
            "[[[[1,9],[8,5]],[[7,7],8]],[0,[8,[7,4]]]]\n" +
            "[[6,[4,[4,3]]],[5,[6,[7,2]]]]\n" +
            "[[0,[[9,0],0]],5]\n" +
            "[[[[5,6],[1,3]],[[0,5],[7,5]]],[[[0,4],[3,6]],[8,[3,6]]]]\n" +
            "[[3,[[4,7],[7,0]]],[[[4,1],5],[[6,6],[7,4]]]]\n" +
            "[[[[4,3],[0,1]],[[7,3],[2,3]]],[[[3,7],[2,2]],[6,5]]]\n" +
            "[[1,1],[[[1,4],6],[6,[3,9]]]]\n" +
            "[[[[0,8],[2,0]],5],[4,[[6,1],[2,1]]]]\n" +
            "[[7,[3,[7,2]]],[[7,9],8]]\n" +
            "[[[4,[9,8]],[8,[3,2]]],[7,9]]\n" +
            "[[[4,[4,2]],[5,[0,3]]],[[[4,9],[2,9]],[[1,5],[0,8]]]]\n" +
            "[[1,[[9,8],0]],[5,[[4,3],5]]]\n" +
            "[[[[5,1],3],[[2,9],[9,0]]],[1,[6,3]]]\n" +
            "[[[6,4],[6,1]],7]\n" +
            "[[4,8],[[7,2],6]]\n" +
            "[[[5,[4,8]],[[1,7],[2,8]]],[6,[[8,4],[3,5]]]]\n" +
            "[[5,8],[[[4,0],[6,0]],[5,[6,0]]]]\n" +
            "[[3,[[5,3],8]],[8,5]]\n" +
            "[[[2,6],[1,[2,3]]],[[[1,7],[5,7]],[[0,0],[0,5]]]]\n" +
            "[[0,[[4,3],[3,6]]],[[2,[6,6]],[0,[2,9]]]]\n" +
            "[[[5,9],[6,2]],[[7,6],8]]\n" +
            "[[9,2],[1,[[0,5],[5,0]]]]\n" +
            "[[[3,1],[9,3]],3]\n" +
            "[[[[2,0],[4,2]],6],[[[5,2],[7,8]],[[0,7],3]]]\n" +
            "[[7,[[3,9],[6,3]]],[2,[[6,4],3]]]\n" +
            "[[5,[3,[7,4]]],[[2,5],[0,9]]]\n" +
            "[3,7]\n" +
            "[[3,9],[[[4,4],9],[[3,1],7]]]\n" +
            "[[[[4,0],1],[8,[3,6]]],[[9,[4,4]],[[9,9],9]]]\n" +
            "[[8,[[8,1],5]],[[[9,1],4],[[8,5],3]]]\n" +
            "[[6,[[6,3],[3,7]]],4]\n" +
            "[[[1,[0,8]],9],[[8,5],[3,[0,5]]]]\n" +
            "[[[[3,1],0],[[8,5],[1,0]]],[0,2]]\n" +
            "[[2,[4,7]],2]\n" +
            "[[[2,0],[2,2]],4]\n" +
            "[4,[[5,8],5]]\n" +
            "[[[2,[0,5]],[[3,3],[6,6]]],1]\n" +
            "[[[2,[2,4]],[5,[7,1]]],[3,5]]\n" +
            "[[2,[9,[3,9]]],9]\n" +
            "[[[7,[7,1]],[[5,2],1]],[[2,1],[9,[7,3]]]]\n" +
            "[[4,[4,6]],4]\n" +
            "[[[4,2],[9,[3,8]]],[[2,4],0]]\n" +
            "[[[7,[0,3]],4],[[[1,8],4],[[5,1],1]]]\n" +
            "[[[1,3],3],[[4,9],[[0,0],6]]]\n" +
            "[[[4,1],0],[[[5,6],[0,8]],[[2,1],1]]]\n" +
            "[[3,[3,[7,9]]],[[[6,8],8],[[7,9],3]]]\n" +
            "[[4,[[1,6],[4,6]]],[[1,8],[3,8]]]\n" +
            "[[[[5,9],2],[[6,7],4]],3]\n" +
            "[[[[2,1],[1,9]],7],[[[0,9],[0,5]],[[2,5],[5,0]]]]").lines()

    @Test
    internal fun task1() {

        Assertions.assertThat(
            Day18(input).task1()).isEqualTo(4111)
    }

    @Test
    internal fun task2() {

        Assertions.assertThat(
            Day18(input).task2()).isEqualTo(4917)
    }
}