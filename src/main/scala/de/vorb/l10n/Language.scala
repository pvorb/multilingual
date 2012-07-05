package de.vorb.l10n

/**
 * Trait that can be mixed-in to define a language.
 *
 * Specifies a language code, a language name and a translation method. When
 * using a concrete language that mixes-in this trait, the `apply` method can be
 * used instead of invoking `translate`.
 */
trait Language {

  /**
   * Language code.
   *
   * E.g. "en-US"
   */
  def code: String

  /**
   * Language name.
   *
   * E.g. "English (United States)"
   */
  def name: String

  def apply[T <: Term#Term](term: T) = translate(term)

  /**
   * Translates a given term to this language's equivalent.
   */
  def translate[T <: Term#Term](term: T): String = "[undefined]"
}
