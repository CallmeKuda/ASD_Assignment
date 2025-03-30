package jetbrains.kotlin.course.alias.team

import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory
import org.springframework.stereotype.Service

@Service

class TeamService {
    private val identifierFactory = IdentifierFactory()

    companion object {
        val teamsStorage: MutableMap<Identifier, Team> = mutableMapOf()
    }

    fun generateTeamsForOneRound(numberOfTeams: Int): List<Team> {
        val teams = List(numberOfTeams) {
            val id = identifierFactory.uniqueIdentifier()
            Team(id).also { teamsStorage[id] = it }
        }
        return teams
    }
}
