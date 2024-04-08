package nextstep.ladder.presentation;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

    public void printInputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉽표(,)로 구분하세요.)");
    }

    public void printInputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public void printLadderAndUserNames(Ladder ladder, Users users) {
        System.out.printf("실행 결과%n%n");
        users.getUsers().forEach(user -> System.out.printf("%5s ",user.getUserName()));
        System.out.println();
        ladder.getLines().forEach(this::printLine);
        ladder.getLadderResult().forEach(result -> System.out.printf("%5s ",result));
        System.out.println();
    }

    public void printInputLadderResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    private void printLine(Line line) {
        System.out.print("     ");
        System.out.println(printLineFormat(line));
    }

    private String printLineFormat(Line line) {
        StringBuilder result = new StringBuilder();
        int repeatCount = 5;
        String bridge = "-".repeat(repeatCount);
        String emptyBridge = " ".repeat(repeatCount);
        String deliminator = "|";

        line.getLine().forEach(data -> {
            result.append(deliminator);
            if (data.canMoveRight()) {
                result.append(bridge);
                return;
            }

            result.append(emptyBridge);
        });

        result.delete(result.length() - repeatCount, result.length());

        return result.toString();
    }

    public void printInputUserNameForResult() {
        System.out.println("결과를 보고 싶은 사람은?");
    }

    public void printGameResultByUser(GameResult gameResult, String name) {
        System.out.println("실행 결과");
        System.out.println(gameResult.getGameResultByUserName(name));
        System.out.println();
    }

    public void printGameResultByAllUser(GameResult gameResult, Users users) {
        System.out.println("실행 결과");
        users.getUsers().stream()
                .map(User::getUserName)
                .forEach(name -> System.out.println(name + " : " + gameResult.getGameResultByUserName(name)));
    }
}