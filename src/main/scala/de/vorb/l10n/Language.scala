package de.vorb.l10n

trait Language {
  def code: String
  def name: String
  def apply[T <: Term#Term](term: T) = translate(term)
  def translate[T <: Term#Term](term: T): String = "[undefined]"
}
