package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CreateSortedArrayThroughInstructions_1649Test {

  private final CreateSortedArrayThroughInstructions_1649 solution =
      new CreateSortedArrayThroughInstructions_1649();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 5, 6, 2}, 1),
          arguments(new int[] {1, 2, 3, 6, 5, 4}, 3),
          arguments(new int[] {1, 3, 3, 3, 2, 4, 2, 1, 2}, 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void createSortedArray(int[] input, int expectedResult) {
    int actualResult = solution.createSortedArray(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
