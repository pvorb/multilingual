package de.vorb.l10n

trait Language {
  def code: String
  def name: String
  def apply(term: Term): String
}
