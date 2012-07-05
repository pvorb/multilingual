package de.vorb.l10n

/**
 * Trait for defining the terms, that you want to translate for your
 * application.
 *
 * This extends `Enumeration`, so you can specify terms by adding new `Value`s:
 * `val SomeTerm = Values`
 */
trait Term extends Enumeration {
  /**
   * The Term definition type.
   */
  type Term = Value
}
