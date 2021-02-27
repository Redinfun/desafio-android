package br.com.desafio_phi.utils


class DateFormatter {

    companion object {
        fun dateFormatter(date: String?): String {

            date?.replace("2020", "20")
            val newDate = date?.split("-")?.toTypedArray()

            return "${newDate?.get(1)}/${newDate?.get(0)}"

        }
    }
}