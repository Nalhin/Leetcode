package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ScoreOfParentheses_856Test {
  private final ScoreOfParentheses_856 solution = new ScoreOfParentheses_856();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("()", 1), arguments("(())", 2), arguments("()()", 2), arguments("(()(()))", 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void scoreOfParentheses(String input, int expectedResult) {
    int actualResult = solution.scoreOfParentheses(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
