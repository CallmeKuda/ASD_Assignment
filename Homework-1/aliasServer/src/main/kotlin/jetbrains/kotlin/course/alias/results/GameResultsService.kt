package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.TeamService
import org.springframework.stereotype.Service


@Service
class GameResultsService {
    companion object {
        private val gameHistory: MutableList<GameResult> = mutableListOf()
    }

    fun saveGameResults(result: GameResult) {
        require(result.isNotEmpty()) { "Result must not be empty." }
        require(result.all { it.id in TeamService.teamsStorage.keys }) { "All team IDs must be in the teams storage." }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
}
