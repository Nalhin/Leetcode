package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GenerateParentheses_22Test {

  private final GenerateParentheses_22 solution = new GenerateParentheses_22();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
          arguments(1, List.of("()")));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void generateParenthesis(int input, List<String> expectedResult) {
    List<String> actualResult = solution.generateParenthesis(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
