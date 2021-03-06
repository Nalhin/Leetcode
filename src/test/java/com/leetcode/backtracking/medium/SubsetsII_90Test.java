package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubsetsII_90Test {
  private final SubsetsII_90 solution = new SubsetsII_90();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {1, 2, 2},
              List.of(
                  Collections.emptyList(),
                  List.of(1),
                  List.of(1, 2),
                  List.of(1, 2, 2),
                  List.of(2),
                  List.of(2, 2))),
          arguments(new int[] {0}, List.of(Collections.emptyList(), List.of(0))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void subsetsWithDup(int[] nums, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.subsetsWithDup(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
